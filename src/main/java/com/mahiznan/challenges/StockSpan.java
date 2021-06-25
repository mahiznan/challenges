package com.mahiznan.challenges;


import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpanApproach2(int price[], int n) {
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        //1, 1, 2, 5, 1, 7
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && price[i] > price[stack.peek()]) {
                int j = stack.pop();
                if (!stack.isEmpty()) {
                    span[stack.peek()] += span[j];
                }
            }
            stack.push(i);
            span[i] = 1;
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            if (!stack.isEmpty()) {
                span[stack.peek()] += span[j];

            }
        }
        return span;


    }

    public static int[] calculateSpanApproach1(int[] price, int n) {
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            span[i] = getStreak(price, i);
        }
        return span;
    }

    private static int getStreak(int[] price, int p) {
        int streak = 1;
        for (int i = p - 1; i >= 0; i--) {
            if (price[p] >= price[i])
                streak++;
            else
                break;
        }
        return streak;
    }

    public static void main(String[] args) {
//        int[] price = {10, 4, 5, 90, 120, 80};
        int[] price = {1, 1, 2, 5, 1, 7};
        System.out.println(Arrays.toString(calculateSpanApproach2(price, price.length)));

    }
}
