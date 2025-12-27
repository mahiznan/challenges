package com.mahiznan.faang;

import java.util.Arrays;

/*
Given two sorted arrays A and B, find the merged sorted array C by merging A and B.

Example:
A: [1, 2, 3, 4, 4]
B: [2, 4, 5, 5]
C: [1, 2, 2, 3, 4, 4, 4, 5, 5]
Testing
Input Format
First-line contains an integer ‘T’ denoting the number of test cases.

For each test case the input has three lines:

Two space-separated integers ‘n’ and ‘m’ denoting the length of the array A and B respectively.
n space-separated integers denoting the elements of the array A.
m space-separated integers denoting the elements of the array B.
Output Format
For each test-case, the output has a line with n+m space separated integers denoting the elements of the array C.

Sample Input
2
5 2
1 3 3 4 4
5 6
6 2
1 3 3 3 3 4
9 11
Expected Output
1 3 3 4 4 5 6
1 3 3 3 3 4 9 11
Constraints
1 <= T <= 100
1 <= n, m <= 104
1 <= Ai, Bi <= 105


 */

public class MergeSortedArray {

    public void mergeApproach1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public int[] mergeApproach2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (j < n) {
            if (i < m && arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < m) {
            result[k++] = arr1[i++];
        }

        return result;

    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
//        int[] nums1 = {1,2,3};
//        int[] nums2 = {2,5,6};
//        int[] nums1 = {1,2,3};
//        int[] nums2 = {};
//        int[] nums1 = {4, 5, 6, 0, 0, 0};
//        int[] nums2 = {1, 2, 3};
//        int[] nums1 = {1, 2, 3, 4, 4};
//        int[] nums2 = {2, 4, 5, 5};
        int[] nums1 = {1, 3, 3, 3, 3, 4};
        int[] nums2 = {9, 11};

        int[] result = m.mergeApproach2(nums1, nums2);
        System.out.println("Result = " + Arrays.toString(result));
    }
}
