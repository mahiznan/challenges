package com.mahiznan.challenges;

class BracketCombination {

    /*
    private static void _printParenthesis(char[] str, int pos, int n, int open, int close, int depth) {
        System.out.println("Current depth " + depth);
        System.oußt.println("Depth: " + depth + " String: " + Arrays.toString(str) + " POS : " + pos + " Open: " + open + " Close: " + close + " n: " + n);
        if (close == n) {
            for (char c : str) System.out.print(c);
            System.out.println();
        } else {
            if (open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos + 1, n, open, close + 1, depth + 1);
                System.out.println(" After close call depth: " + depth + " : String: " + Arrays.toString(str) + " POS : " + pos + " Open: " + open + " Close: " + close + " n: " + n);

            }
            if (open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos + 1, n, open + 1, close, depth + 1);
                System.out.println(" After open call depth: " + depth + " : String: " + Arrays.toString(str) + " POS : " + pos + " Open: " + open + " Close: " + close + " n: " + n);
            }
        }
    }*/

    public static void BracketCombinations(int num) {
        if (num > 0) {
            char[] str = new char[num * 2];
//            _printParenthesis(str, 0, num, 0, 0, 1);
        }
//        System.out.println(num);
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print(calculateBalancedParanthesis(s.nextInt()));
        System.out.print(calculateBalancedParenthesis(6));
//        calculateBalancedParanthesis(2);
    }

    private static int calculateBalancedParenthesis(int n) {
        char[] str = new char[n * 2];
        if (n > 0)
            return printBalancedParenthesis(str, n, 0, 0, 0, 0);
        return 0;
    }

    private static int printBalancedParenthesis(char[] str, int n, int position, int open, int close, int res) {
        if (close == n) {
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

