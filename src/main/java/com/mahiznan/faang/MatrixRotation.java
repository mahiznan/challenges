package com.mahiznan.faang;

import java.util.Arrays;

/*
Given a matrix, rotate the matrix 90 degrees clockwise.

Examples
Matrix:
1 2 3
4 5 6
7 8 9
After rotation:
7 4 1
8 5 2
9 6 3
Matrix:
1 2
3 4
5 6
After rotation:
5 3 1
6 4 2
Testing
Sample Input
The first line contains ‘T’ denoting the independent test cases.

For each test case, The first line contains the numbers 'n' and ‘m’ denoting the number of rows and columns respectively.

The next ‘n’ lines contains ‘m’ space-separated integers denoting elements of a 2-d matrix.

Expected Output
For each test case, It contains ‘m’ lines containing ‘n’ space-separated integers denoting the resultant matrix.

Sample Input
2
3 3
1 2 3
4 5 6
7 8 9
3 2
1 2
3 4
5 6
Expected Output
7 4 1
8 5 2
9 6 3
5 3 1
6 4 2
Sample Input
1
3 1
1
2
3
Expected Output
3 2 1
Constraints
1 <= T <= 10

1 <= n,m <= 100

0 <= matrix[i][j] <= 100000
 */
public class MatrixRotation {

    int[][] rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix must be non-empty.");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a new matrix to hold the rotated result
        int[][] rotatedMatrix = new int[cols][rows];

        // Fill the rotated matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
//        int[][] matrix = {{1}, {2}, {3}};
//        int[][] matrix = {{1}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        MatrixRotation matrixRotation = new MatrixRotation();
        System.out.println(Arrays.deepToString(matrixRotation.rotateMatrix(matrix)));
    }
}
