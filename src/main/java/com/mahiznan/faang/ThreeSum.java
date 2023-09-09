package com.mahiznan.faang;

import java.util.*;

/*
Given an array A, find all unique triplets in the array whose sum is equal to zero.

Example:
A: [1, 1, 0, -1, -2]
Triplets: [
  [-2, 1, 1],
  [-1, 0, 1]
]
Note: Each triplet should be sorted. The resultant array should be sorted as well.

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case, the input contains two lines:

An integer 'n' denoting the size of the array.
n space-separated integers denoting the elements of A.
Output Format
For each test case, the output contains the following lines.

A line containing an integer ‘m’ denoting the number of unique triplets.
m lines contain three integers representing each triplet.
Sample Input
2
4
-1 0 1 2
5
1 -1 9 -8 0
Expected Output
1
-1 0 1
2
-8 -1 9
-1 0 1
Constraints
1 <= T <= 10
3 <= n <= 3000
-10^5 <= Ai <= 10^5
 */
public class ThreeSum {


    static List<List<Integer>> threeSumRecursive(int[] A, int n) {
        return null;
    }


    static List<List<Integer>> threeSum_Good(int[] A) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++)
                for (int k = j + 1; k < A.length; k++)
                    if (A[i] + A[j] + A[k] == 0) {
                        List<Integer> list = (List.of(A[i], A[j], A[k]));
                        res.add(list);
                    }
        }
        return List.copyOf(res);
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 0, -1, -2};
        System.out.println(threeSum_Good(A));
    }
}
