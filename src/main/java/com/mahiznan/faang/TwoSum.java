package com.mahiznan.faang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array A and an integer target,
find the indices of the two numbers in the array whose sum is equal to the given target.

Note: The problem has exactly one solution. Do not use the same element twice.

Example
A: [1, 3, 3, 4]
target: 5
Answer: [0, 3]
Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case, the input has three lines:

An integer ’n’ denoting the length of the array.
n space-separated integers denoting the elements of the array.
An integer ‘target’ denoting the target value.
Output Format
For each test case, the output has two space-separated integers ‘i’ and ‘j’
denoting the indices of the array.

Sample Input
2
6
8 2 10 4 1 3
9
5
2 4 2 3 2
7
Expected Output
0 4
1 3
Constraints
1 <= T <= 10
2 <= n <= 105
-109 <= Ai <= 109
-109 <= target <= 109

Companies : Amazon,Flipkart,Google,Hike,Microsoft,Morgan Stanley,Sap Labs,Zoho
 */
public class TwoSum {

    static int[] twoSum(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            int v = target - A[i];
            if (map.containsKey(v) && map.get(v) != i) {
                return new int[]{i, map.get(v)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] A = {1, 3, 4, 6};
//        int target = 7;
//        int[] A = {2, 4, 2, 3, 2};
//        int target = 7;
        int[] A = {8, 2, 10, 4, 1, 3};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(A, target)));
    }
}
