package com.mahiznan.java.champion;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;


/**
 * - JAVA CONCURRENCY DEMO
 * - Demonstrates 5 real problems with synchronized
 * - and how ReentrantLock solves each one.
 * -
 * - Run each demo one at a time. Read the output carefully.
 */
public class ConcurrencyDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=================================================");
        System.out.println("  JAVA CONCURRENCY — synchronized vs ReentrantLock");
        System.out.println("=================================================\n");

//         Comment/uncomment to run specific demos
        demo1_NotInterruptible();
        demo2_NoTimeout();
        demo3_Starvation();
        demo4_SpuriousWakeup();
        demo5_NoIntrospection();


    }

    // =========================================================================
    // DEMO 1: synchronized IS NOT INTERRUPTIBLE
    // Problem: Once blocked on synchronized, thread cannot be interrupted
    // =========================================================================
    static void demo1_NotInterruptible() throws InterruptedException {
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("DEMO 1:synchronized is NOT interruptible ");
        System.out.println("─────────────────────────────────────────────────");


        Object lock = new Object();

        // Thread A grabs the lock and holds it for 5 seconds (simulating slow I/O)
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("[Thread A] Acquired lock — holding for 5 seconds (slow I/O simulation)");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
                System.out.println("[Thread A] Released lock");
            }
        }, "Thread-A");

        // Thread B tries to get the lock — will be blocked
        Thread threadB = new Thread(() -> {
            System.out.println("[Thread B] Trying to acquire lock...");
            synchronized (lock) {
                System.out.println("[Thread B] Got the lock!");
            }
        }, "Thread-B");

        threadA.start();
        Thread.sleep(100); // Let A get the lock first
        threadB.start();
        Thread.sleep(500); // Let B block on lock

        // Try to interrupt Thread B — THIS HAS NO EFFECT on synchronized
        System.out.println("[Main] Interrupting Thread B — watch what happens...");
        threadB.interrupt();

        Thread.sleep(1000);
        System.out.println("[Main] Thread B state: " + threadB.getState()); // Still BLOCKED!
        System.out.println("[Main] Thread B is STUCK — interrupt had NO effect on synchronized block");

        threadA.join();
        threadB.join();

        System.out.println("\n--- NOW WITH ReentrantLock ---\n");

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread threadC = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("[Thread C] Acquired lock — holding for 5 seconds");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {
            } finally {
                reentrantLock.unlock();
            }
        }, "Thread-C");

        Thread threadD = new Thread(() -> {
            System.out.println("[Thread D] Trying to acquire lock (interruptibly)...");
            try {
                reentrantLock.lockInterruptibly(); // CAN be interrupted!
                try {
                    System.out.println("[Thread D] Got the lock!");
                } finally {
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                // Thread D handles interrupt gracefully
                System.out.println("[Thread D] Interrupted while waiting! Backing off gracefully.");
                System.out.println("[Thread D] System stays alive — can retry, log, or fallback.");
            }
        }, "Thread-D");

        threadC.start();
        Thread.sleep(100);
        threadD.start();
        Thread.sleep(500);

        System.out.println("[Main] Interrupting Thread D — watch what happens...");
        threadD.interrupt();
        threadD.join();
        threadC.interrupt();
        threadC.join();

        System.out.println("\n✓ DEMO 1 COMPLETE\n");


    }

    // =========================================================================
    // DEMO 2: synchronized HAS NO TIMEOUT — deadlock is unrecoverable
    // Problem: No way to give up waiting — system hangs forever
    // =========================================================================
    static void demo2_NoTimeout() throws InterruptedException {
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("DEMO 2:synchronized has NO timeout —tryLock saves you ");
        System.out.println("─────────────────────────────────────────────────");
        ReentrantLock lock = new ReentrantLock();

        Thread longRunningThread = new Thread(() -> {
            lock.lock();
            System.out.println("[Long Runner] Holding lock for 3 seconds...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            } finally {
                lock.unlock();
            }
            System.out.println("[Long Runner] Released lock");
        });

        longRunningThread.start();
        Thread.sleep(100); // Let it acquire the lock

        // Thread tries to get lock with 1 second timeout
        System.out.println("[Main] Trying to acquire lock with 1 second timeout...");
        try {
            boolean acquired = lock.tryLock(1, TimeUnit.SECONDS);
            if (acquired) {
                try {
                    System.out.println("[Main] Got the lock!");
                } finally {
                    lock.unlock();
                }
            } else {
                // GRACEFUL HANDLING — system stays alive
                System.out.println("[Main] Could not acquire lock in 1 second — giving up gracefully");
                System.out.println("[Main] In production: log alert, return fallback, increment metric");
                System.out.println("[Main] System is STILL ALIVE and responsive");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        longRunningThread.join();

        System.out.println("\n✓ DEMO 2 COMPLETE\n");


    }

    // =========================================================================
    // DEMO 3: synchronized CAUSES STARVATION
    // Problem: JVM picks arbitrary thread — waiting threads can be passed over (barging)
    // =========================================================================
    static void demo3_Starvation() throws InterruptedException {
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("DEMO 3:Starvation —unfair vs fair lock ");
        System.out.println("─────────────────────────────────────────────────");

        int threadCount = 5;
        int iterations = 10;

        // UNFAIR lock (default) — like synchronized behavior
        System.out.println("--- UNFAIR ReentrantLock (simulates synchronized behaviour) ---");
        List<Integer> unfairOrder = runLockContention(new ReentrantLock(false), threadCount, iterations);
        printOrder(unfairOrder, threadCount);
        System.out.println("Notice: threads run in long streaks (barging) — a thread that just released");
        System.out.println("        the lock re-grabs it while waiting threads are delayed");

        Thread.sleep(500);

        // FAIR lock — threads get lock in arrival order
        System.out.println("\n--- FAIR ReentrantLock ---");
        List<Integer> fairOrder = runLockContention(new ReentrantLock(true), threadCount, iterations);
        printOrder(fairOrder, threadCount);
        System.out.println("Notice: threads take turns in arrival order (round-robin) — no barging");

        System.out.println("\n✓ DEMO 3 COMPLETE\n");
    }

    // Prints the order in which threads acquired the lock, plus per-thread totals and longest streak
    static void printOrder(List<Integer> order, int threadCount) {
        StringBuilder sb = new StringBuilder("Acquisition order: ");
        int[] totals = new int[threadCount];
        int longest = 0, streak = 0, prev = -1;
        for (int id : order) {
            sb.append(id).append(' ');
            totals[id]++;
            streak = (id == prev) ? streak + 1 : 1;
            longest = Math.max(longest, streak);
            prev = id;
        }
        System.out.println(sb);
        for (int i = 0; i < threadCount; i++) {
            System.out.printf("  Thread-%d: %d times%n", i, totals[i]);
        }
        System.out.println("Longest streak by one thread: " + longest + " (1 = perfectly alternating)");
    }

    // Returns the order (thread ids) in which the lock was acquired
    static List<Integer> runLockContention(ReentrantLock lock, int threadCount, int iterations)
            throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(threadCount);
        Thread[] threads = new Thread[threadCount];
        List<Integer> order = new ArrayList<>(threadCount * iterations); // guarded by 'lock'

        for (int i = 0; i < threadCount; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < iterations; j++) {
                        lock.lock();
                        try {
                            order.add(id);
                            Thread.sleep(1); // simulate tiny work
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        } finally {
                            lock.unlock();
                        }
                    }
                } finally {
                    latch.countDown();
                }
            }, "Thread-" + i);
        }

        for (Thread t : threads) t.start();
        latch.await();
        return order;
    }

    // =========================================================================
    // DEMO 4: Object.wait/notify IS BROKEN — spurious wake-ups + one wait set
    // Problem: notifyAll wakes ALL threads including irrelevant ones
    // Solution: Multiple Condition variables — precise signaling
    // =========================================================================
    static void demo4_SpuriousWakeup() throws InterruptedException {
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("DEMO 4:Multiple Conditions —precise producer/consumer ");
        System.out.println("─────────────────────────────────────────────────");

        int BUFFER_SIZE = 100;
        Queue<Integer> buffer = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock(true);
        Condition notFull = lock.newCondition(); // producers wait here
        Condition notEmpty = lock.newCondition(); // consumers wait here

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 8; i++) {
                lock.lock();
                try {
                    while (buffer.size() == BUFFER_SIZE) {
                        System.out.println("[Producer] Buffer full — waiting on notFull condition");
                        notFull.await();
                    }
                    buffer.offer(i);
                    System.out.println("[Producer] Produced: " + i + " | Buffer size: " + buffer.size());
                    notEmpty.signal(); // wake ONLY a consumer — not all threads
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }, "Producer");

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 8; i++) {
                lock.lock();
                try {
                    while (buffer.isEmpty()) {
                        System.out.println("[Consumer] Buffer empty — waiting on notEmpty condition");
                        notEmpty.await();
                    }
                    int val = buffer.poll();
                    System.out.println("[Consumer] Consumed: " + val + " | Buffer size: " + buffer.size());
                    notFull.signal(); // wake ONLY a producer — not all threads
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }, "Consumer");

        consumer.start();
        Thread.sleep(100);
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("\n✓ DEMO 4 COMPLETE — Producer woke ONLY consumers. Consumer woke ONLY producers.\n");

    }

    // =========================================================================
    // DEMO 5: synchronized HAS NO INTROSPECTION
    // Problem: Cannot inspect lock state — blind in production
    // Solution: ReentrantLock provides rich monitoring API
    // =========================================================================
    static void demo5_NoIntrospection() throws InterruptedException {
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("DEMO 5:Lock introspection —monitoring in production ");
        System.out.println("─────────────────────────────────────────────────");

        ReentrantLock lock = new ReentrantLock();
        CountDownLatch holdingLatch = new CountDownLatch(1);
        CountDownLatch releaseLatch = new CountDownLatch(1);

        // Thread holds the lock
        Thread holder = new Thread(() -> {
            lock.lock();
            try {
                holdingLatch.countDown(); // signal that lock is held
                releaseLatch.await();     // wait for signal to release
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }, "Lock-Holder");

        // Two threads waiting for the lock
        Thread waiter1 = new Thread(() -> {
            try {
                holdingLatch.await();
                lock.lock();
                try {
                    Thread.sleep(10);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Waiter-1");

        Thread waiter2 = new Thread(() -> {
            try {
                holdingLatch.await();
                lock.lock();
                try {
                    Thread.sleep(10);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Waiter-2");

        holder.start();
        holdingLatch.await(); // wait until lock is held

        waiter1.start();
        waiter2.start();
        Thread.sleep(200); // let waiters block

        // Now introspect the lock — IMPOSSIBLE with synchronized
        System.out.println("\n[Monitor] Lock state inspection:");
        System.out.println("  Is locked?              " + lock.isLocked());
        System.out.println("  Held by current thread? " + lock.isHeldByCurrentThread());
        System.out.println("  Waiting threads count:  " + lock.getQueueLength());
        System.out.println("  Has queued threads?     " + lock.hasQueuedThreads());
        System.out.println("  Is waiter1 queued?      " + lock.hasQueuedThread(waiter1));
        System.out.println("  Is waiter2 queued?      " + lock.hasQueuedThread(waiter2));
        System.out.println("  Is fair lock?           " + lock.isFair());
        System.out.println("  Hold count:             " + lock.getHoldCount());

        System.out.println("\n[Monitor] In production: expose these as metrics/alerts");
        System.out.println("[Monitor] High queue length = contention = scale up or optimize");
        System.out.println("[Monitor] With synchronized: you are BLIND to all of this");

        // Release the lock
        releaseLatch.countDown();
        holder.join();
        waiter1.join();
        waiter2.join();

        System.out.println("\n✓ DEMO 5 COMPLETE\n");

        System.out.println("=================================================");
        System.out.println("  ALL DEMOS COMPLETE");
        System.out.println("=================================================");

    }
}