package com.mahiznan.neet150;

import java.util.HashMap;
import java.util.Map;
/*
Given an integer array nums, return true if any value appears more than once in the array,
otherwise return false.

Example 1:
Input: nums = [1, 2, 3, 3]
Output: true

Example 2:
Input: nums = [1, 2, 3, 4]
Output: false

Recommended Time & Space Complexity
You should aim for a solution with O(n) time and O(n) space, where n is the size of the input array.
 */


public class Q01_ContainsDuplicate {
    public static void main(String[] args) {
//        int nums[] = {1, 2, 3, 3};
        int nums[] = {1, 2, 3, 4};
        System.out.println(hasDuplicate(nums));
    }

    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num))
                return true;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}

