package com.mahiznan.faang;

/*
Longest Common Prefix
Easy
30
Given a list of strings A, find the longest common prefix among all the strings.

Example
A: [“abc”, “abef”, “abccc”, “abftg”]

Longest common prefix: “ab”

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case, the input has two lines:

An integer ‘n’ denoting the number of strings in list A.
n space separated strings.
Output Format
For each test case, the output has one line with a string denoting the longest common prefix.

Sample Input
4
4
apple apply apollo abracadabra
2
qwerty hello
3
helloworld hell hello
1
hello
Expected Output
a

hell
hello
Constraints
1 <= T <= 10
1 <= n <= 100
1 <= Ai size <= 1000

 */
public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] str) {
        StringBuilder res = new StringBuilder();
        String s = str[0];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < str.length; j++) {
                if (str[j].length() <= i || s.charAt(i) != str[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String[] str = {"apple", "apply", "apollo", "abracadabra"};
        String[] str = {"qwerty", " hello"};
//        String[] str = {"helloworld", "hello", "hell"};
        System.out.println(longestCommonPrefix(str));
    }
}
