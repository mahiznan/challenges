package com.mahiznan.challenges;

/*
Given a dictionary of words and an M x N board where every cell has one character. Find all possible different words from the dictionary that can be formed by a sequence of adjacent characters on the board. We can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell.


Example 1:

Input:
N = 1
dictionary = {"CAT"}
R = 3, C = 3
board = {{C,A,P},{A,N,D},{T,I,E}}
Output:
CAT
Explanation:
C A P
A N D
T I E
Words we got is denoted using same color.
Example 2:

Input:
N = 4
dictionary = {"GEEKS","FOR","QUIZ","GO"}
R = 3, C = 3
board = {{G,I,Z},{U,E,K},{Q,S,E}}
Output:
GEEKS QUIZ
Explanation:
G I Z
U E K
Q S E
Words we got is denoted using same color.

Your task:
You don’t need to read input or print anything. Your task is to complete the function wordBoggle() which takes the dictionary contaning N space-separated strings and R*C board as input parameters and returns a list of words that exist on the board (NOTE: All words returned must be different even it occurs multiple times in the dictionary).


Expected Time Complexity: O(4^(N^2))
Expected Auxiliary Space: O(N^2)


Constraints:
1 ≤ N ≤ 15
1 ≤ R, C ≤ 50
1 ≤ length of Word ≤ 60
All words of Dictionary and all characters of board are in uppercase letters from 'A' to 'Z'
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class WordBoggle {

    static String[] wordBoggle(char[][] board, String[] dictionary) {
        List<String> l = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<String> hs = new HashSet<>();
        for (String str : dictionary) {
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < m; q++) {
                    if (!hs.contains(str) && dfs(board, str, vis, p, q, 0)) {
                        hs.add(str);
                        l.add(str);
                        break;
                    }
                }
            }
        }
        String[] res = new String[l.size()];
        int k = 0;
        for (String i : l)
            res[k++] = i;
        return res;
    }

    public static boolean dfs(char[][] board, String str, boolean[][] vis, int i, int j, int p) {
        if (str.length() == p)
            return true;
        boolean res = false;
        if (issafe(vis, i, j)) {
            if (str.charAt(p) == board[i][j]) {
                vis[i][j] = true;
                res = dfs(board, str, vis, i + 1, j, p + 1);
                res |= dfs(board, str, vis, i, j + 1, p + 1);
                res |= dfs(board, str, vis, i - 1, j, p + 1);
                res |= dfs(board, str, vis, i, j - 1, p + 1);
                res |= dfs(board, str, vis, i + 1, j - 1, p + 1);
                res |= dfs(board, str, vis, i - 1, j + 1, p + 1);
                res |= dfs(board, str, vis, i - 1, j - 1, p + 1);
                res |= dfs(board, str, vis, i + 1, j + 1, p + 1);
                vis[i][j] = false;
                return res;
            }
        }
        return res;
    }

    public static boolean issafe(boolean[][] vis, int i, int j) {
        return i >= 0 && i < vis.length && j >= 0 && j < vis[0].length && !vis[i][j];
    }


    public static void main(String[] args) {

        //Test Case 1
        String[] dictionary = new String[1];
        dictionary[0] = "CAT";
        char[][] board = new char[3][3];
        board[0][0] = 'C';
        board[0][1] = 'A';
        board[0][2] = 'P';
        board[1][0] = 'A';
        board[1][1] = 'N';
        board[1][2] = 'D';
        board[2][0] = 'T';
        board[2][1] = 'I';
        board[2][2] = 'E';

        String[] wordsFound = wordBoggle(board, dictionary);
        for (String word : wordsFound) {
            System.out.println(word);
        }
        //Test Case 2
        dictionary = new String[4];
        dictionary[0] = "GEEKS";
        dictionary[1] = "FOR";
        dictionary[2] = "QUIZ";
        dictionary[3] = "GO";
        board = new char[3][3];
        board[0][0] = 'G';
        board[0][1] = 'I';
        board[0][2] = 'Z';
        board[1][0] = 'U';
        board[1][1] = 'E';
        board[1][2] = 'K';
        board[2][0] = 'Q';
        board[2][1] = 'S';
        board[2][2] = 'E';

        wordsFound = wordBoggle(board, dictionary);
        for (String word : wordsFound) {
            System.out.println(word);
        }
        //Test case 3
        dictionary = new String[6];
        dictionary[0] = "B";
        dictionary[1] = "EDC";
        dictionary[2] = "DDD";
        dictionary[3] = "CC";
        dictionary[4] = "CCB";
        dictionary[5] = "FFB";
        board = new char[6][2];
        board[0][0] = '5';
        board[0][1] = '2';
        board[1][0] = 'D';
        board[1][1] = 'D';
        board[2][0] = 'C';
        board[2][1] = 'C';
        board[3][0] = 'B';
        board[3][1] = 'F';
        board[4][0] = 'D';
        board[4][1] = 'D';
        board[5][0] = 'C';
        board[5][1] = 'D';

        wordsFound = wordBoggle(board, dictionary);
        for (String word : wordsFound) {
            System.out.println(word);
        }

    }
}
