package com.mahiznan.challenges;

public class EditDistance {

    /*

    Given two strings s and t. Return the minimum number of operations required to convert s to t.

    The possible operations are permitted:
    Insert a character at any position of the string.
    Remove any character from the string.
    Replace any character from the string with any other character.
     */

    // geek -> gesek
    // ecfbefdcfca -> badfcbebbf
    // dceccabbb => bbefcdeabfbfa

    static int editDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;

        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "geek", t = "gesek"; // 1
//        String s = "ecfbefdcfca", t = "badfcbebbf"; //9
//        String s = "dceccabbb", t = "bbefcdeabfbfa"; //8
        System.out.println(editDistance(s, t));
    }
}
