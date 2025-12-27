package com.mahiznan.faang;

import java.util.HashMap;

/*
A message containing letters from 'A' to 'Z' is being encoded into numbers using the following encoding:

'A' -> 1
'B' -> 2
.
.
.
'Y' -> 25
'Z' -> 26
Given an encoded string, find the number of ways it can be decoded.

Examples
decoded: 123
encoded: ["ABC", "LC", "AW"]
answer: 3
decoded: 36
encoded: ["CF"]
answer: 1
decoded: 106
encoded: ["JF"]
answer: 1
decoded: 306
encoded: []
answer: 0
The total number of ways to decode can be larger than the largest 32 bit number. Return your answer with module 109 + 7.

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.
For each test case, the input has a string denoting the decoded string

Output Format
For each test case, the output contains a line with one integer denoting the total number of ways. Return the answer with module 109 + 7.

Sample Input
4
123
36
106
306
Expected Output
3
1
1
0
Constraints
1 <= T <= 30
1 <= length of string <= 104
The string contains only digits and may contain leading zeroes



 */
public class DecodeWays {


    private int recursiveDecode(String s, int index) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }

        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }

        // Decode single digit
        int ways = recursiveDecode(s, index + 1);

        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += recursiveDecode(s, index + 2);
        }

        return ways;
    }

    int numDecodings_TimeLimit_Exceeds(String str) {
        return recursiveDecode(str, 0);
    }

    int mod = 1000000007;
    HashMap<Integer, Integer> memoize = new HashMap<Integer, Integer>();

    int countWays_Memorization(String str, int start, int end) {
        if (start > end || (start == end && str.charAt(start) != '0')) {
            return 1;
        }
        if (str.charAt(start) == '0') {
            return 0;
        }
        if (memoize.containsKey(start)) {
            return memoize.get(start);
        }
        int ways = 0;
        ways = (ways + countWays_Memorization(str, start + 1, end)) % mod;
        if (start < end && (str.charAt(start) == '1' || str.charAt(start) <= '2' && str.charAt(start + 1) <= '6')) {
            ways = (ways + countWays_Memorization(str, start + 2, end)) % mod;
        }
        memoize.put(start, ways);
        return ways;
    }

    int numDecodings_DynamicProgramming(String s) {
        int n = s.length();
        if (n == 0) return 0;

        final int MOD = 1_000_000_007;

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Single digit decode
            dp[i] = dp[i + 1] % MOD;

            // Two digit decode
            if (i + 1 < n) {
                int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (val >= 10 && val <= 26) {
                    dp[i] = (dp[i] + dp[i + 2]) % MOD;
                }
            }
        }

        return dp[0];
    }

    int numDecodings_Memorization(String str) {
        memoize.clear();
        return countWays_Memorization(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String decoded = "1239876293847928336582374218458732058734285207398";
        DecodeWays decodeWays = new DecodeWays();
        long start = System.nanoTime();
        System.out.println(decodeWays.numDecodings_TimeLimit_Exceeds(decoded));
        long end = System.nanoTime();
        System.out.println("Recursive Approach Time taken (ns): " + (end - start));
        start = System.nanoTime();
        System.out.println(decodeWays.numDecodings_Memorization(decoded));
        end = System.nanoTime();
        System.out.println("Recursive Approach with Memorisation Time taken (ns): " + (end - start));
        start = System.nanoTime();
        System.out.println(decodeWays.numDecodings_DynamicProgramming(decoded));
        end = System.nanoTime();
        System.out.println("Dynamic Programming Approach Time taken (ns): " + (end - start));
//        "Encoded": "123"
//        Decoded: ["ABC", "LC", "AW"]
    }
}
