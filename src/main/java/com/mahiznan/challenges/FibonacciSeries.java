package com.mahiznan.challenges;

public class FibonacciSeries {
    public static void main(String[] args) {
        int i = 20;
        printFibonacciSeries(i);
    }

    private static void printFibonacciSeries(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            System.out.print("0");
        } else if (i == 2) {
            System.out.print("0 1");
        } else {
            int[] dp = new int[2];
            dp[1] = 1;
            System.out.print("0 1 ");
            for (int k = 3; k <= i; k++) {
                int t = dp[0];
                dp[0] = dp[1];
                dp[1] = t + dp[1];
                System.out.print(dp[1] + " ");
            }

        }

    }
}
