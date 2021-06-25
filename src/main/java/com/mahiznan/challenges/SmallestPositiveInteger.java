package com.mahiznan.challenges;
/*
Given an array of size N, find the smallest positive integer value that cannot be represented
as sum of some elements from the array.

Example 1:

Input:
N = 6
array[] = {1, 10, 3, 11, 6, 15}
Output:
2
Explanation:
2 is the smallest integer value that cannot
be represented as sum of elements from the array.

Example 2:

Input:
N = 3
array[] = {1, 1, 1}
Output:
4
Explanation:
1 is present in the array.
2 can be created by combining two 1s.
3 can be created by combining three 1s.
4 is the smallest integer value that cannot be
represented as sum of elements from the array.


Your Task:
You dont need to read input or print anything. Complete the function smallestpositive() which takes the array and N as input parameters and returns the smallest positive integer value that cannot be represented as sum of some elements from the array.


Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 10^6
1 ≤ array[i] ≤ 10^9
Array may contain duplicates.
 */

import java.util.Arrays;

public class SmallestPositiveInteger {
    static long smallestPositive(long[] array, int n) {
        Arrays.sort(array);
        long res = 1;
        for (int i = 0; i < n && array[i] <= res; i++)
            res += array[i];
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {1, 1, 3, 4};
//        long[] arr = {1, 2, 3, 6, 10, 11, 15};
//        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15};
        int n = arr.length;
        System.out.println(smallestPositive(arr, n));
    }
}

/*

If elements from 0 to (i-1) can represent 1 to ‘res-1’,
then elements from 0 to i can represent from 1 to ‘res + arr[i] – 1’
be adding ‘arr[i]’ to all subsets that represent 1 to ‘res’

 */
