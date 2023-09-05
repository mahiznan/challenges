package com.mahiznan.faang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Regular Expression Matching
Hard
80
Implement regular expression matching.

In a regular expression:

a-z matches the corresponding character.
. matches any single character.
* matches zero or more of the preceding character.
The entire input string should be matched.

The function would take a string s and the regular expression pattern p.

Examples
s: "a"
p: "a"
match: true
s: "aa"
p: "a"
match: false
s: "ab"
p: "a."
match: true
s: "aa"
p: "a*"
match: true
s: "b"
p: "ba*"
match: true
s: "aabcd"
p: "a*b*c*d*"
match: true
Testing
Input Format
The first line contains an integer ‘T’, denoting the number of test cases.

For each test case the input has two strings s and p.

Expected Output
For each test case, a line containing true or false depending on the match.
 */
public class RegularExpressionMatcher {

    static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean match = !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (match && isMatch(s.substring(1), p)));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static void main(String[] args) {
        String str = "aa";
        String pattern = "a";
        str = "b";
        pattern = "ba*";
        str = "aabcd";
        pattern = "a*b*c*d*";
        str = "aab";
        pattern = "c*a*b";
        str = "aaa";
        pattern = "ab*a*c*a";
        str = "abc";
        pattern = "a.c";
        System.out.println(isMatch(str, pattern));
    }
}
