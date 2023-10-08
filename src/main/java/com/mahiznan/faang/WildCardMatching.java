package com.mahiznan.faang;

import java.util.Arrays;

/*
Implement wildcard matching.

In a wildcard string:

a-z matches the corresponding character.
? matches any single character.
* matches any sequence of characters (incl. empty sequence).
The entire input string should be matched.

The function would take a string s and the wildcard pattern p.

Examples
s: "a"
p: "a"
match: true
s: "aa"
p: "a"
match: false
s: "ab"
p: "a?"
match: true
s: "aabcd"
p: "a*"
match: true
s: "bacd"
p: "ba*cd"
match: true
s: "bacde"
p: "ba*cd"
match: false
s: "acdfbqcd"
p: "a*b?cd"
match: true
Testing
Input Format
The first line contains an integer ‘T’, denoting the number of test cases.

For each test case the input has two strings s and p.

Expected Output
For each test case, a line containing true or false depending on the match.

Sample Input
7
a a
aa a
ab a?
aabcd a*
bacd ba*cd
bacde ba*cd
acdfbqcd a*b?cd
Expected Output
true
false
true
true
true
false
true
Constraints
1 <= T <= 100
1 <= s.length <= 500
1 <= p.length <= 500
s contains only lowercase english alphabets.
p contains '?', '*' and lowercase english alphabets.


 */
public class WildCardMatching {

    static boolean isMatch_Better(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);
        return match(s.length() - 1, p.length() - 1, s, p, dp) != 0;
    }

    static int match(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;
        if (i < 0) {
            for (int j1 = 0; j1 <= j; j1++) {
                if (p.charAt(j1) != '*')
                    return 0;
            }
            return 1;
        }
        if (j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = match(i - 1, j - 1, s, p, dp);
        int ans = 0;
        if (p.charAt(j) == '*') {
            for (int a = 0; a <= s.length(); a++) {
                ans = ans + match(i - a, j - 1, s, p, dp);
            }
            return dp[i][j] = ans;
        }
        return dp[i][j] = 0;
    }

    static boolean isMatch_Good(String s, String p) {
        if (s.isEmpty() && p.isEmpty())
            return true;
        if (s.isEmpty()) {
            boolean isMatch = true;
            for (char c : p.toCharArray()) {
                if (c != '*') {
                    isMatch = false;
                    break;
                }
            }
            return isMatch;
        }
        if (p.isEmpty())
            return false;

        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatch_Good(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch_Good(s, p.substring(1)) || isMatch_Good(s.substring(1), p.substring(1)) || isMatch_Good(s.substring(1), p);
        } else
            return false;
    }

    static boolean isMatch_Best(String s, String p) {
        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;

        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            } else {
                return false;
            }
        }

        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == p.length();
    }

    public static void main(String[] args) {
        String string = "bacd";
        String pattern = "ba*cd";
        string = "bacde";
        pattern = "ba*cd";
//        string = "acdfbqcd";
//        pattern = "a*b?cd";
//        string = "";
//        pattern = "*******";
        string = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        pattern = "***bba**a*bbba**aab**b";
//        System.out.println(isMatch_Good(string, pattern));
//        System.out.println(isMatch_Better(string, pattern));
        System.out.println(isMatch_Best(string, pattern));
    }
}
