package com.mahiznan.challenges;

public class RotateMatrix {

    static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int v : ints) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    static void rotate90DegreeAndPrint(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotateMatrixBy90Degree(int[][] matrix) {
        printMatrix(matrix);
        System.out.println("------------------");
        rotate90DegreeAndPrint(matrix);

    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        rotateMatrixBy90Degree(matrix);

    }
}
