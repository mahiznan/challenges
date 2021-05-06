package com.mahiznan.challenges;

import java.util.HashMap;
import java.util.Map;

public class SimpleFraction {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        int remaining = numerator % denominator;
        Map<Integer, Integer> history = new HashMap<>();
        while (remaining != 0) {
            remaining *= 10;
            if (history.containsKey(remaining)) {
                int index = history.get(remaining);
                return numerator / denominator + "." + res.substring(0, index) + "(" + res.substring(index) + ")";
            } else {
                history.put(remaining, res.length());
                res.append(remaining / denominator);
                remaining = remaining % denominator;
            }
        }
        if (res.length() > 0)
            return numerator / denominator + "." + res;
        return "" + numerator / denominator;
    }

    public static void main(String[] args) {
//        int numerator = 11;
//        int denominator = 18;
        int numerator = 2;
        int denominator = 3;
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
