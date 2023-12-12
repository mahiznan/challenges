package com.mahiznan.faang;

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
        int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rotatedMatrix[]
            }

        }

        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
