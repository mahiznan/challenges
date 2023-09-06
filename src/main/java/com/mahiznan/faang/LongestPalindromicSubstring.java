package com.mahiznan.faang;

/*
Given a string, return the longest palindromic substring (LPS) in it.

Note: There can be multiple palindromic substrings with the max length. In case of conflict,
return the substring that has the smallest starting index.

Examples
str: "abcdcab"
LPS: "cdc"
str: "abcdcba"
LPS: "abcdcba"
str: "abcd"
LPS: "a"
str: "abaadcd"
LPS: "aba"
Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.
For each test case, the input contains a string.

Output Format
For each test case, the output contains a line with one string denoting the LPS.

Sample Input
5
abcdcab
abcdcba
abcd
abaadcd
workattech
Expected Output
cdc
abcdcba
a
aba
tt
Constraints
1 <= T <= 100
1 <= string length <= 500
The string contains only lowercase english alphabets
 */
public class LongestPalindromicSubstring {
    static String longestPalindrome_Best(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            while (i + 1 + palindromeRadii[i] < n &&
                    i - 1 - palindromeRadii[i] >= 0 &&
                    sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLength) / 2;
        String longestPalindrome = s.substring(startIndex, startIndex + maxLength);

        return longestPalindrome;
    }

    static boolean isPalindrome(String str) {
        int l = str.length();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
//        System.out.printf("%s is palindrome %n", str);
        return true;

    }

    static String longestPalindrome_Better(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }


    static String longestPalindrome_Good(String s) {
        String lps = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString) && subString.length() > lps.length()) {
                    lps = subString;
                    System.out.println("Current Palindrome " + lps);
                }
            }
        }
        return lps;
    }






    public static void main(String[] args) {
        String str = "abcdcab";
        str = "abcdcba";
        str = "abcd";
        str = "babad";
        str = "cbbd";
        str = "abaadcd";
        str = "ababa";
        System.out.println(longestPalindrome_Good(str));
        System.out.println(longestPalindrome_Better(str));
        System.out.println(longestPalindrome_Best(str));
    }


}
