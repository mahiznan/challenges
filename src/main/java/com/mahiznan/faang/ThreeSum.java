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

    static List<List<Integer>> threeSum_Better(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    res.add(List.of(arr[i], arr[l], arr[r]));
                    l++;
                    r--;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }
        return res;
    }

    static List<List<Integer>> threeSum_Best(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (i == 0 || A[i] != A[i + 1]) {
                int l = i + 1, r = A.length - 1;
                while (l < r) {
                    if (A[l] + A[r] == -1 * A[i]) {
                        res.add(List.of(A[i], A[l], A[r]));
                        while (l < r && A[l] == A[l + 1]) l++;
                        while (r > l && A[r] == A[r - 1]) r--;
                        l++;
                        r--;
                    } else if (A[l] + A[r] < -1 * A[i]) l++;
                    else r--;
                }
            }
        }
        return res;
    }


    static List<List<Integer>> threeSum_Good(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int[] A = Arrays.copyOf(nums, nums.length);

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
        System.out.println(threeSum_Better(A));
        System.out.println(threeSum_Best(A));
    }
}
