package com.mahiznan.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Palindrom {

    public static boolean canMakePalindrom(String str) {
        boolean res = true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i) + 1));

            } else {
                map.put(str.charAt(i), 1);
            }
        }
        Set<Character> chars = map.keySet();
        //abb
        //If str length is even
        if (str.length() % 2 == 0) {
            for (Character c : chars) {
                res = map.get(c) % 2 == 0;
                if (!res) break;
            }
        } else {
            // Usecase : aab (Test)
            // [a] - 2
            // [b] - 1
            //If str length is odd
            int v = 0;
            for (Character c : chars) {
                v += map.get(c) % 2; //V=0, v=1
            }
            res = v == 1;
        }
        return res;
    }


    public static void main(String args[]) {
        System.out.println(canMakePalindrom("aab"));
    }
}
