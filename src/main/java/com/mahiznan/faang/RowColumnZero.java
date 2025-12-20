package com.mahiznan.faang;

import java.util.Stack;

/*
Given a matrix, if any of the cells in the matrix is 0, set all the elements in its row and column to 0.

Examples
1 1 1        1 0 1
1 0 1   =>   0 0 0
1 1 1        1 0 1

0 1 2        0 0 0
3 4 5   =>   0 4 5
1 2 3        0 2 3

0 1 0        0 0 0
3 4 5   =>   0 4 0
1 2 3        0 2 0

0 1 0        0 0 0
3 0 5   =>   0 0 0
1 2 3        0 0 0
 */

public class RowColumnZero {
    record Position(int row, int col) {

    }

    void printMatrix(int[][] matrix) {
        System.out.println("-------------------");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    void setRowZeroes(int[][] matrix, int row, int col) {
        printMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        printMatrix(matrix);
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
        printMatrix(matrix);
    }

    void setRowColumnZeroes(int[][] matrix) {
        Stack<Position> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    stack.push(new Position(i, j));
                }
            }
        }

        while (!stack.isEmpty()) {
            Position position = stack.pop();
            setRowZeroes(matrix, position.row, position.col);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        RowColumnZero rowColumnZero = new RowColumnZero();
        rowColumnZero.setRowColumnZeroes(matrix);
    }
}
