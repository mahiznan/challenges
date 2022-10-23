package com.mahiznan.challenges;

import java.util.Arrays;
import java.util.Comparator;

/*

Maximum profit by choosing a subset of intervals.

Given a list intervals of n intervals, the ith element [s,e,p] denotes the starting point s, ending point e,
and the profit p earned by choosing the ith interval. Find the maximum profit one can achieve by choosing a subset
of non overlapping intervals.

Two intervals [s1,e1,p1] and [s2,e2,p2] are said to be non overlapping if [e1<=s2] and [s1<s2]

Example 1:

Input:
        n = 3
        intervals = {
        {1, 4, 4},
        {2, 3, 7},
        {2, 2, 4}
        }
        Output:
        7
        Explanation:
        One can choose interval [2, 3, 7] for a profit of 7.

        Example 2:

Input:
        n = 3
        intervals = {
        {1, 2, 4},
        {1, 5, 7},
        {2, 4, 4}
        }
        Output:
        8
        Explanation:
        One can choose intervals [1, 2, 4] and [2, 4, 4] for a
        profit of 8.

You don't need to print or output anything.
Complete the function maximum_profit() which takes an integer n and a 2D integer array intervals and returns an integer,
 denoting the maximum profit which one can get by choosing the non-overlapping intervals.

 Conditions:
    1 <= n and n <= 104
    1 <= starting point of ith interval <= ending point of ith interval <= 105
    1 <= profit earned by choosing ith interval <= 105
*/

public class MaxProfitFromSubset {
    public static boolean canIncludeThisTrip(int lastTrip, int currentTrip, int[][] trips) {
        if (currentTrip == 0 || lastTrip == -1)
            return true;
        return trips[lastTrip][1] <= trips[currentTrip][0] && trips[lastTrip][0] < trips[currentTrip][0];
    }

    public static int maximum_profit(int n, int[][] intervals) {
        return drive(0, -1, 0, intervals);
    }

    public static int drive(int currentProfit, int lastTrip, int currentTrip, int[][] trips) {
        int profit1 = 0, profit2;
        if (currentTrip >= trips.length)
            return currentProfit;
        if (canIncludeThisTrip(lastTrip, currentTrip, trips))
            profit1 = drive(currentProfit + trips[currentTrip][2], currentTrip, currentTrip + 1, trips);
        profit2 = drive(currentProfit, lastTrip, currentTrip + 1, trips);
        return Math.max(profit1, profit2);
    }

    static int find_nearest_equal_or_greater(int start, int end, int value, int n, int[][] intervals) {
        // If nothing found, position will be n.
        int position = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (intervals[mid][0] >= value) {
                position = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return position;
    }

    static int maximum_profit_helper(int index, int n, int[][] intervals, int[] dp) {
        if (index >= n) {
            return 0;
        }

        // `dp[index]` stores the maximum profit one can get by choosing
        // non-overlapping intervals from `index` to `n - 1`.
        if (dp[index] != -1) {
            return dp[index];
        }

        int answer = maximum_profit_helper(index + 1, n, intervals, dp);
        int new_index = find_nearest_equal_or_greater(
                index + 1, n - 1, intervals[index][1], n, intervals);
        answer =
                Math.max(answer, intervals[index][2] +
                        maximum_profit_helper(new_index, n, intervals, dp));

        return dp[index] = answer;
    }

    public static int maximum_profitApproach2(int n, int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    if (a1[1] == a2[1])
                        return a1[2] - a2[2];
                    return a1[1] - a2[1];
                }
                return a1[0] - a2[0];
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maximum_profit_helper(0, n, intervals, dp);
    }

    public static void main(String[] args) {

        // Test case 1
        int n = 3;
        int[][] intervals = {
                {1, 2, 4},
                {1, 5, 7},
                {2, 4, 4}
        };

        /*
        // Test case 2
        int n = 3;
        int[][] intervals = {
                {1, 4, 4},
                {2, 3, 7},
                {2, 2, 4}
        };

        /*
        // Test case 3
        int n = 3;
        int[][] intervals = {
                {1, 5, 7},
                {2, 4, 4},
                {1, 2, 4},
        };*/

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        System.out.println(maximum_profit(n, intervals));
    }
}
