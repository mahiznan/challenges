package com.mahiznan.challenges.arrays;

import java.util.HashMap;

public class AllUniqueCharacters {

    //Approach 1
    static boolean isUniqueChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) != null)
                return false;
            map.put(c, 0);
        }
        return true;
    }

    //Approach 2
    static boolean isUniqueChars2(String s) {
        if (s.length() > 128)
            return false;
        boolean[] uniq = new boolean[128];

        for (char c : s.toCharArray()) {
            if (uniq[c]) {
                return false;
            }
            uniq[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "raja";
//        System.out.println(isUniqueChars(s));
//        System.out.println(isUniqueChars2(s));
        System.out.println(isUniqueChars3(s));
    }

    //Approach 3
    static boolean isUniqueChars3(String str) {

       /* int x, y;
        x = 1;
        y = -10;
        System.out.println("Bitwise Left Shift: x<<2 = " + (x << 2));
        System.out.println("Bitwise Left Shift: x<<17 = " + (x << 17));
        System.out.println("Bitwise Right Shift: x>>2 = " + (x >> 2));
        System.out.println("Bitwise Zero Fill Right Shift: x>>>2 = " + (x >>> 2));
        System.out.println("Bitwise Zero Fill Right Shift: y>>>2 = " + (y >>> 2));*/

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println("Checking for " + str.charAt(i));
            System.out.println("Shifting " + val);
            int shiftValue = (1 << val);
            System.out.println("1 << val ==" + toBinary(shiftValue, 20));
            System.out.println("Checker  ==" + toBinary(checker, 20));
            System.out.println("(checker & (1 << val)) ==" + (checker & (1 << val)));
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static String toBinary(int n, int len) {
        StringBuilder binary = new StringBuilder();
        for (long i = (1L << len - 1); i > 0; i = i / 2) {
            binary.append((n & i) != 0 ? "1" : "0");
        }
        return binary.toString();
    }
}
