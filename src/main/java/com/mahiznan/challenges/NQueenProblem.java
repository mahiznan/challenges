package com.mahiznan.challenges;

public class NQueenProblem {


    static void solveNQueenBoard(int[][] board, int row, int N) {
        if (row >= N) {
            printBoard(board);
            System.out.println("-------------------");
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canPlaceQueen(board, row, col)) {
                board[row][col] = 1;
                solveNQueenBoard(board, row + 1, N);
                board[row][col] = 0;
            }
        }
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int v : row) {
                System.out.print(v + "  ");
            }
            System.out.println();
        }
    }

    private static boolean canPlaceQueen(int[][] board, int row, int col) {
        //To ensure no queens in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        //To ensure no queens in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        //To ensure no queen in the left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        //To ensure no queen in the right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] board = new int[N][N];
        solveNQueenBoard(board, 0, N);
    }
}
