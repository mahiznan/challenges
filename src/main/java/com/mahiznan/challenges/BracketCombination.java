package com.mahiznan.challenges;


import java.util.Arrays;

/*
In how many ways valid parenthesis can be formed for the given number
Example 1:
For 2 it can be formed in 2 ways
{{}}
{}{}

Example 1:
For 3 it can be formed in 5 ways
{{{}}}
{{}{}}
{{}}{}
{}{{}}
{}{}{}

 */
class BracketCombination {


    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print(calculateBalancedParanthesis(s.nextInt()));
        int n = 2;
        System.out.println(calculateBalancedParenthesis(n));
    }

    private static int calculateBalancedParenthesis(int n) {
        char[] str = new char[n * 2];
        int res = 0;
        if (n > 0) {
            res = printBalancedParenthesis(str, n, 0, 0, 0, 0);
            System.out.println(res);
            res = calculateParenthesis(str, n, 0, 0, 0, 0);
            System.out.println(res);
        }
        return res;
    }


    private static int calculateParenthesis(char[] str, int n, int pos, int open, int close, int res) {
        if (close == n) {
            System.out.println(str);
            return res + 1;
        }
        if (open < n) {
            str[pos] = '{';
            res = calculateParenthesis(str, n, pos + 1, open + 1, close, res);
        }
        if (close < open) {
            str[pos] = '}';
            res = calculateParenthesis(str, n, pos + 1, open, close + 1, res);
        }
        return res;

    }

    private static int printBalancedParenthesis(char[] str, int n, int position, int open, int close, int res) {
        if (close == n) {
            System.out.println(str);
            return res + 1;
        } else {
            if (open < n) {
                str[position] = '{';
                res = printBalancedParenthesis(str, n, position + 1, open + 1, close, res);
            }
            if (close < open) {
                str[position] = '}';
                res = printBalancedParenthesis(str, n, position + 1, open, close + 1, res);
            }
        }
        return res;
    }
}

