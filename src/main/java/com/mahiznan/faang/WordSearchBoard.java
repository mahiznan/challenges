package com.mahiznan.faang;

import java.util.HashMap;
import java.util.Map;

/*
you are given a board of size n*m, containing an English alphabet in each cell. You are also given a word, find if the word exists on the board.

The word can be constructed from letters of sequentially adjacent cells. Cells which have a common edge are considered adjacent. The same cell may not be used more than once.

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.

For each test case the input has the following lines:

Two space-separated integers 'n' and 'm' denoting the number of rows and columns of the board.
A 'word' to find.
n lines, each containing m space-separated characters denoting the characters in each cell of the board.
Output Format
For each test case, the output has a line with 1 or 0, denoting whether the word exists on the board or not.

Sample Input
2
3 4
WORKAT
A W O R
T E R K
T A K A
3 4
ATTECH
A W O R
T E R K
T E T A
Expected Output
1
0
Constraints
1 <= T <= 10
1 <= n, m <= 100
1 <= word.length <= 200
boardij = 'A' to 'Z'

 */
public class WordSearchBoard {

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: full word matched
        if (index == word.length()) return true;

        // Boundary and mismatch checks
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore neighbors
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        // Backtrack
        board[i][j] = temp;

        return found;
    }

    boolean wordExists(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void main() {

//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        char[][] board = {{'A', 'W', 'O', 'R'}, {'T', 'E', 'R', 'K'}, {'T', 'A', 'K', 'A'}};
        String word = "WORKAT";
        WordSearchBoard ws = new WordSearchBoard();
        System.out.println(ws.wordExists(board, word));

    }
}
