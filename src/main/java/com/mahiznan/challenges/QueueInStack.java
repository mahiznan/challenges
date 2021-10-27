package com.mahiznan.challenges;

/*
Implement queue using stack
 */

import java.util.Stack;

class Queue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    /*The method pop which return the element popped out of the stack*/
    int dequeue() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        int v = output.pop();
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
        return v;
    }

    /* The method push to push element into the stack */
    void enqueue(int x) {
        input.push(x);
    }
}

public class QueueInStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.print(queue.dequeue());
        queue.enqueue(4);
        System.out.print(" " + queue.dequeue());
    }
}
