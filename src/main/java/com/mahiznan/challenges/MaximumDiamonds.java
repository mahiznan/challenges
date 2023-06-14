package com.mahiznan.challenges;

import java.util.PriorityQueue;

/*
There are N bags with diamonds in them.
The i'th of these bags contains A[i] diamonds.
If you drop a bag with A[i] diamonds, it changes to A[i]/2 diamonds and you gain A[i] diamonds.
Dropping a bag takes 1 minute.
Find the maximum number of diamonds that you can take if you are given K minutes.

Example 1:
Input:
N = 5, K = 3
A[] = {2, 1, 7, 4, 2}
Output:
14
Explanation:
The state of bags is:
2 1 7 4 2
You take all diamonds from Third bag (7).
The state of bags becomes: 2 1 3 4 2
Take all diamonds from Fourth bag (4).
The state of bags becomes: 2 1 3 2 2
Take all diamonds from Third bag (3).
The state of bags becomes: 2 1 1 2 2
Hence, number of Diamonds = 7+4+3 = 14.

 */
public class MaximumDiamonds {

    private static int calculateDiamonds(int N, int K, int[] A) {
        int maxDiamonds = 0;
        for (int i = 0; i < K; i++) {
            int max = -1, index = -1;
            for (int j = 0; j < N; j++) {
                if (A[j] > max) {
                    max = A[j];
                    index = j;
                }
            }
            maxDiamonds += max;
            A[index] = A[index] / 2;
        }
        return maxDiamonds;
    }

    //Optimized Approach
    private static long calculateDiamondsOptimal(int N, int K, int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        long sum = 0;

        for (int i = 0; i < N; i++) {
            maxHeap.offer(A[i]);
        }

        for (int i = 0; i < K; i++) {
            int max = maxHeap.poll();
            sum += max;
            maxHeap.offer(max / 2);
        }

        return sum;
    }

    public static void main(String[] args) {
//        int N = 5, K = 3;
//        int[] A = {2, 1, 7, 4, 2};

        int N = 3, K = 2;
        int[] A = {7, 1, 2};
        System.out.println(calculateDiamonds(N, K, A));
    }
}
