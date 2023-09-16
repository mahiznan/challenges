package com.mahiznan.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Generate Parentheses
Medium
50
Given a number n denoting n pairs of parentheses, return all valid expressions using the n pairs of parentheses.

Examples
n: 2
Answer: [
    "(())",
    "()()",
]
n: 3
Answer: [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
]
Testing
Input Format
The first line contains an integer ‘T’, denoting the number of test cases.

For each test case, the input has an integer n.

Output Format
For each test case, the output has multiple lines each denoting a valid parenthesis expression.

Sample Input
3
1
2
3
Expected Output
()
(())
()()
((()))
(()())
(())()
()(())
()()()
Constraint
1 <= T <= 8

1 <= n <= 8
 */
public class ParenthesesString {


    static List<String> generateParentheses_Better(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    static void dfs(int l, int r, final StringBuilder s, List<String> res) {

        if (l == 0 && r == 0) {
            res.add(s.toString());
            return;
        }

        if (l > 0) {
            s.append("(");
            dfs(l - 1, r, s, res);
            s.deleteCharAt(s.length() - 1);
        }
        if (l < r) {
            s.append(")");
            dfs(l, r - 1, s, res);
            s.deleteCharAt(s.length() - 1);
        }

    }

    static List<String> generateParentheses_Good(int n) {
        return formParentheses(0, 0, n * 2, "", new ArrayList<>());
    }

    static List<String> formParentheses(int openingCount, int closingCount, int n, String str, List<String> res) {
        if (closingCount > openingCount)
            return res;
        if (n == 0) {
            if (openingCount == closingCount) {
                res.add(str);
            }
            return res;
        }
        formParentheses(openingCount + 1, closingCount, n - 1, str + "(", res);
        formParentheses(openingCount, closingCount + 1, n - 1, str + ")", res);
        return res;
    }


    public static void main(String[] args) {
        int n = 3;
//        List<String> result = generateParentheses_Good(n);
        List<String> result = generateParentheses_Better(n);
        System.out.println(result);
    }
}
