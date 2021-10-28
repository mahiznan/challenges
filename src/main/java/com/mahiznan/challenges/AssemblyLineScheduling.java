package com.mahiznan.challenges;

public class AssemblyLineScheduling {

    static int calculateMinCost(int[][] a, int[][] t, int[] e, int[] x, int s) {

        int[] L1 = new int[s];
        int[] L2 = new int[s];

        L1[0] = e[0] + a[0][0];
        L2[0] = e[1] + a[1][0];

        for (int i = 1; i < s; i++) {
            L1[i] = Math.min(L1[i - 1] + a[0][i], L2[i - 1] + t[1][i] + a[0][i]);
            L2[i] = Math.min(L2[i - 1] + a[1][i], L1[i - 1] + t[0][i] + a[1][i]);
        }
        return Math.min(L1[s - 1] + x[0], L2[s - 1] + x[1]);
    }


    static int calculateMinCostPractice(int[][] cost, int[][] time, int[] ecost, int[] xcost, int s) {
        int[][] dp = new int[2][s];
        dp[0][0] = ecost[0] + cost[0][0];
        dp[1][0] = ecost[1] + cost[1][0];

        for (int i = 1; i < s; i++) {
            dp[0][i] = Math.min(dp[0][i - 1] + cost[0][i], dp[1][i - 1] + time[1][i] + cost[0][i]);
            dp[1][i] = Math.min(dp[1][i - 1] + cost[1][i], dp[0][i - 1] + time[0][i] + cost[1][i]);
        }

        return Math.min(dp[0][s - 1] + xcost[0], dp[1][s - 1] + xcost[1]);
    }


    public static void main(String[] args) {
        int[][] a = {{4, 5, 3, 2}, {2, 10, 1, 4}};
        int[][] t = {{0, 7, 4, 5}, {0, 9, 2, 8}};
        int[] e = {10, 12};
        int[] x = {18, 7};
        System.out.println(calculateMinCost(a, t, e, x, a[0].length));
        System.out.println(calculateMinCostPractice(a, t, e, x, a[0].length));
    }
}
