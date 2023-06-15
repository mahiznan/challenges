package com.mahiznan;


import java.util.Objects;

//NotWorking
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
