package com.mahiznan.challenges.cci.arrays;

import java.util.Arrays;
import java.util.Objects;

public class PermutationFinder {

    //Approach 1
    static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] sortedArray1 = str1.toCharArray();
        Arrays.sort(sortedArray1);
        char[] sortedArray2 = str2.toCharArray();
        Arrays.sort(sortedArray2);
        return Objects.equals(Arrays.toString(sortedArray1), Arrays.toString(sortedArray2));
    }

    //Approach 2
    static boolean isPermutation2(String s1, String s2) {
        int[] count = new int[128];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (char c : s2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "god ", s2 = "dog a";
        System.out.println(isPermutation2(s1, s2));
    }


}
