package com.mahiznan.faang;
/*

Given a string s, find the length of the longest substring without repeating characters.

Example
s: “workattech”
Result: 6
Explanation: Longest valid substring is “workat”.
s: “mississippi”
Result: 3
Explanation: Longest valid substrings are “mis” and “sip”, both of length 3.
Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case, the input has two lines:

An integer ‘n’ denoting the length of the string.
The string s.
Output Format
For each test case, the output contains a line with an integer denoting the length of the longest substring in s having distinct characters.

Sample Input
2
10
workattech
11
mississippi
Expected Output
6
3
Constraints
1 <= T <= 10
1 <= n <= 106
The string s consists of lowercase English characters.
 */


import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    static int longestSubstringWithoutRepeat(String s) {
        if (s.length() == 1)
            return 1;
        int len = s.length(), index = 0, curPos = 0, maxLength = 0, curLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (index < len && curPos < len) {
            if (map.containsKey(s.charAt(curPos))) {
                if (curLength > maxLength)
                    maxLength = curLength;
                map.clear();
                index++;
                curPos = index;
                curLength = 0;
            } else {
                map.put(s.charAt(curPos), 1);
                curLength++;
                curPos++;
                if (curPos == len && curLength > maxLength) {
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s;
        s = "bbbbb";
        s = "abcabc";
        s = "pwwkew";
        s = "abcabcbb";
        s = "workattech";
        s = "mississippi";
        s = " ";
        s = "au";
        s = "dvdf";
        System.out.println(longestSubstringWithoutRepeat(s));
    }
}
