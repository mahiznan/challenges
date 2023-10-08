package com.mahiznan.faang;

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
    static boolean isMatch(String s, String p) {
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
        if(p.isEmpty())
            return false;

        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p);
        } else
            return false;
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
        string="babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        pattern="***bba**a*bbba**aab**b";
        System.out.println(isMatch(string, pattern));
    }
}
