package com.mahiznan.challenges;

public class SubsetSum {

    //Approach 1, Recursive approach
    static boolean isSubsetSum(int[] set,
                               int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    static boolean canFormSubset(int[] set,
                                 int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }


    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        boolean res = isSubsetSum(set, n, sum);
        if (res)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
        res = canFormSubset(set, n, sum);
        if (res)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");


    }
}
