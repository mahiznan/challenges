/*
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
Find the missing element.

        Example 1:

        Input:
        N = 5
        A[] = {1,2,3,5}
        Output: 4

        Example 2:

        Input:
        N = 10
        A[] = {1,2,3,4,5,6,7,8,10}
        Output: 9


        Your Task :
        You don't need to read input or print anything.
        Complete the function MissingNumber() that takes array and N as input  parameters and returns the value of the missing number.


        Expected Time Complexity: O(N)
        Expected Auxiliary Space: O(1)


        Constraints:
        1 ≤ N ≤ 10^6
        1 ≤ A[i] ≤ 10^6
        */

package com.mahiznan.challenges;


public class MissingNumber {

    static int missingNumber(int[] array, int n) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return (n * (n + 1)) / 2 - sum;
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] a = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a = {1, 2, 3, 5};

        System.out.println(missingNumber(a, a.length + 1));
    }
}
