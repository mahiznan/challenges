package com.mahiznan.faang;

import java.util.Stack;

/*
Given a string with the just the six characters - ‘(’, ‘)’, ‘{’, ‘}’, ‘[’ and ‘]’. Determine if the string is balanced.

A string is balanced if all brackets exist in pairs and are closed in the correct order.

Example:
String: ({})[]

Result: Balanced

String: {()})(

Result: Not Balanced

String: {(})[]

Result: Not Balanced

Testing
Input Format
The first line contains an integer ‘T’, denoting the number of test cases.

For each test case, a line containing a parentheses string.

Output Format
For each test case, a line containing 1 or 0 if the string is valid or not respectively.

Sample Input
3
({})[]
{()})(
{(})[]
Expected Output
1
0
0
Constraints
1 <= T <= 100
1 <= String Length <= 104
 */
public class BalancedParentheses {

    static boolean isBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()
                        || (str.charAt(i) == '}' && stack.pop() != '{')
                        || (str.charAt(i) == ']' && stack.pop() != '[')
                        || (str.charAt(i) == ')' && stack.pop() != '('))
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})[]";
        s = "{()})(";
        s = "()";
        s = "()[]{}";
        System.out.println(isBalancedParentheses(s));
    }
}
