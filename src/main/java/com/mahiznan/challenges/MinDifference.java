package com.mahiznan.challenges;

/*
Given a string S and a list of strings.
You have to find the string from the list which is a substring of S with minimum difference K.
Here difference means number of different characters.You can do only one operation on the string list[i]

You can rearrange the characters of the string list[i].

Example 1:

    Input: S = abcde
    list[] = {cdf,efd,klda,eaf}
    Output: 1
    Explanation:
    Difference of the string cdf with the
    substring cde is 1.
    Difference of the string efd with the
    substring cde is 1 if we rearrange the
    characters of efd.
    Difference of the string klda with the
    substring abcd is 2 if we rearrange the
    characters of klda.
    Difference of the string eaf with the
    substring cde is 2 if we rearrange the
    characters of efd.
    So minimum difference is 1.


Example 2:
    Input: S = abc
    list[] = {abd,ace,ab}
    Output: 0


Your Task:
You don't need to read input or print anything.
Your task is to complete the function minimumDifference()
which takes a string S and a list of string as input parameters and returns an integer denoting the minimum difference.

Given a string S and a list of strings.
You have to find the string from the list which is a substring of S with minimum difference K.
Here difference means number of different characters.You can do only one operation on the string list[i]:
 */


public class MinDifference {
    public static void main(String[] args) {
        //Test case 1
//        String s = "abc";
//        String[] list = {"abd", "ace", "ab"};

        //Test case 2
        String s = "abcde";
        String[] list = {"cdf", "efd", "klda", "eaf"};

        System.out.println(minimumDifference(3, list, s));
    }

    public static int minimumDifference(int n, String[] list, String s) {
        // code here
        int ans = Integer.MAX_VALUE;
        for (String t : list) {
            if (t.length() <= s.length()) {
                int op1 = getDifference(t, s);
                ans = Math.min(ans, op1);
            }
        }
        return ans;
    }

    private static int getDifference(String t, String s) {
        int i = 0;
        int j = 0;
        int[] A = new int[26];
        int[] B = new int[26];
        for (int a = 0; a < t.length(); a++) {
            A[t.charAt(a) - 'a']++;
        }
        for (j = 0; j < t.length() - 1; j++) {
            B[s.charAt(j) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        while (j < s.length()) {
            B[s.charAt(j) - 'a']++;
            int op1 = 0;
            for (int a = 0; a < 26; a++) {
                if (B[a] > 0) op1 += Math.abs(A[a] - B[a]);
            }
            ans = Math.min(ans, op1);
            B[s.charAt(i) - 'a']--;
            j++;
            i++;
        }
        return ans;
    }
}
