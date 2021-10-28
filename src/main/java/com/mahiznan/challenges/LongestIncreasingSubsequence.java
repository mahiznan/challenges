package com.mahiznan.challenges;

public class LongestIncreasingSubsequence {


    static int maxValue;

    public static void main(String[] args) {
//        int[] ar = {3, 10, 2, 11};
//        int[] ar = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] ar = {4, 10, 4, 3, 8, 9};
        int length = ar.length;
        maxValue = 1;
        System.out.println("Longest Increasing subsequence is " + subsequence(ar, length));
    }

    private static int subsequence(int[] array, int n) {
        if (n == 1)
            return 1;
        int res, maxEnding = 1;
        for (int i = 1; i < n; i++) {
            res = subsequence(array, i);
            if (array[i - 1] < array[n - 1] && res + 1 > maxEnding) {
                maxEnding = res + 1;
            }
        }
        if (maxValue < maxEnding)
            maxValue = maxEnding;
        return maxEnding;
    }
}
