package com.mahiznan.faang;

/*
Given an array and a number k, find the sum of the subarray that has the maximum sum among all the subarrays of size k.

Example
Array: [3, 5, 6, 2, 4, 7, 8]
k: 3
Here, the subarrays of size k and their sum are:
[3 5 6] => 14
[5 6 2] => 13
[6 2 4] => 12
[2 4 7] => 13
[4 7 8] => 19
Answer: 19
Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case, the input contains two lines:

An integer 'n' denoting the size of the array A and 'k' denoting the size of the subarray.
n space-separated integers denoting elements of the array A.
Output format
For each test-cases, the output has a single integer denoting the maximum subarray sum.

Sample Input
2
7 3
3 5 6 2 4 7 8
6 1
1 3 3 3 4 4
Expected Output
19
4
Constraints
1 <= T <= 100

1 <= n <= 10^4

1 <= k <= n

1 <= Ai <= 10^4
 */
public class MaximumKSumArray {

    //{3, 5, 6, 2, 4, 7, 8}
    static int maxKSubarraySum(int[] A, int k) {
        int max = 0, curMax = 0;
        for (int i = 0; i < k; i++)
            max += A[i];
        curMax = max;
        for (int i = k; i < A.length; i++) {
            curMax = curMax - A[i - k] + A[i];
            if (curMax > max)
                max = curMax;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 5, 6, 2, 4, 7, 8};
//        int k = 3;
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maxKSubarraySum(arr, k));
    }
}
