/*
A Simple Fraction
Medium Accuracy: 39.14% Submissions: 5446 Points: 4

Given a fraction. Convert it into a decimal.
If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 3
Output: "0.(3)"
Explanation: 1/3 = 0.3333... So here 3 is
recurring.

Example 2:

Input: numerator = 5, denominator = 2
Output: "2.5"
Explanation: 5/2 = 2.5

Your Task:
You don't need to read or print anything. Your task is to complete the function fractionToDecimal() which takes numerator and denominator as input parameter and returns its decimal form in string format.

Expected Time Complexity: O(k) where k is constant.
Expected Space Complexity: O(k)

Constraints:
1 ≤ numerator, denominator ≤ 2000
*/
package com.mahiznan.challenges;

import java.util.HashMap;
import java.util.Map;

public class SimpleFraction {
    private static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        StringBuilder result = new StringBuilder();
        if (numerator < 0 || denominator < 0) {
            result.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long q = numerator / denominator;
        long r = numerator % denominator * 10L;
        result.append(q);

        if (r > 0) {
            result.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (r > 0) {
                if (map.containsKey(r)) {
                    int index = map.get(r);
                    String part1 = result.substring(0, index);
                    String part2 = "(" + result.substring(index) + ")";
                    return part1 + part2;
                }
                System.out.println("Putting " + r + "=>" + result.length() + " in to the map");
                map.put(r, result.length());
                result.append(r / denominator);
                r = r % denominator * 10;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        int numerator = 11;
//        int denominator = 18;
        int numerator = 2;
        int denominator = 3;
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
