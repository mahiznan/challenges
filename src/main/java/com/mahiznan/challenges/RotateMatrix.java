package com.mahiznan.challenges;

public class RotateMatrix {

    static void rotateAntiClockwise90Degree(int[][] matrix, int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = t;
            }
        }
        printMatrix(matrix);
    }

    static void rotateClockwise90Degree(int[][] matrix, int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = t;
            }
        }
        printMatrix(matrix);
    }


    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    static void rotate90DegreeAndPrint(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        //Test case 3

        /* Input
        1 2 3 4
        5 6 7 8
        9 10 11 12
        13 14 15 16

        Output
        4  8 12 16
        3  7 11 15
        2  6 10 14
        1  5  9 13
         */
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        //        rotate90DegreeAndPrint(matrix);
        printMatrix(matrix);
//        rotateAntiClockwise90Degree(matrix, matrix.length);
        rotateClockwise90Degree(matrix, matrix.length);
    }
}
