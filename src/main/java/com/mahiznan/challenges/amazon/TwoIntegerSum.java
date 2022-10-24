package com.mahiznan.challenges.amazon;

import java.util.HashMap;
import java.util.Map;

/*
Determine if the sum of two integers is equal to the given value
Given an array of integers and a value,
determine if there are any two integers in the array whose sum is equal to the given value.
Return true if the sum exists and return false if it does not. Consider this array and the target sums:

5 7 1 2 8 4 3
Target Sum
10
7+3=10, 2+8=10
Target Sum
19
No 2 values sum up to 19
 */
public class TwoIntegerSum {

    static boolean determineSum(int[] A, int s) {
        boolean res = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            map.put(j, j);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (map.containsKey(s - v)) {
                return true;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
