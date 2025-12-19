package com.mahiznan.faang;

/*
A rat is located at the top-left cell of a m*n matrix. The rat wants to get to the cheese which is at the bottom-right cell of the matrix.

The rat can move only in one of the two directions - down and right. How many unique paths can the rat take to reach the destination?
 */

public class UniquePath {

    static final int MOD = 1_000_000_007;

    int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(3, 2));

    }
}
