package com.mahiznan.challenges;

import java.util.HashMap;
import java.util.Map;

public class MaxDifferenceSubString {

    static int getDifference(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int difference = -1;
        for (char c : s.toCharArray()) {
            count.merge(c, 1, Integer::sum);
        }
        if (count.get('0') == null) {
            System.out.println("Result for String " + s + " => " + -1);
            return -1;
        }
        if (count.get('1') == null) {
            System.out.println("Result for String " + s + " => " + count.get('0'));
            return count.get('0');
        }
        difference = count.get('0') - count.get('1');
        System.out.println("Result for String " + s + " => " + difference);
        return difference;
    }

    static int maxSubstring(String S) {
        int maxDiff = -1;
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j < S.length() + 1; j++) {
                int currentDiff = getDifference(S.substring(i, j));
                if (currentDiff > maxDiff) {
                    maxDiff = currentDiff;
                }
            }
        }
        return maxDiff;
    }

    static int maxSubstringFastApproach(String S) {
        int cnt0 = 0, cnt1 = 0, ans = -1;

        for (int i = 0; i < S.length(); i++) {
            System.out.println("Current Max " + ans);
            if (S.charAt(i) == '0') cnt0++;
            else cnt1++;
            if (cnt1 >= cnt0) {
                cnt1 = 0;
                cnt0 = 0;
            } else {
                ans = Math.max(ans, cnt0 - cnt1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubstring("11000010001"));
//        System.out.println(maxSubstring("111111"));
//        String S = "10000";
        System.out.println(maxSubstringFastApproach("10000"));
//        System.out.println(maxSubstringFastApproach("110"));
    }
}
