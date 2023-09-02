package com.mahiznan.challenges;


import java.util.Objects;

//NotWorking

/*

Given a string S, find the longest palindromic substring in S.
Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
Palindrome string: A string that reads the same backward. More formally,
S is a palindrome if reverse(S) = S. In case of conflict,
return the substring which occurs first ( with the least starting index).

Ex: 1
Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".

Ex: 2
Input:
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the
longest palindromes with same length.
The result is the one with the least
starting index.
 */
public class LongestPalindrome {

    static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        return Objects.equals(s, stringBuilder.reverse().toString());
    }

    static String longestPalin(String S) {

        String maxPalindrome = "";

        for (int i = 0, j = 1; i < S.length() && j <= S.length(); ) {
            String newString = S.substring(i, j);
            if (isPalindrome(newString) && newString.length() > maxPalindrome.length()) {
                maxPalindrome = newString;
                j++;
                System.out.println("Palindrome " + newString);

            } else {
                System.out.println("Not palindrome " + newString);
                i++;
                j = i + 1;
            }
        }
        return maxPalindrome;
    }

    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println("Max Palindrom is " + longestPalin(s));
    }
}
