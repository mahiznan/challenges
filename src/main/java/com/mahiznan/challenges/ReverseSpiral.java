package com.mahiznan.challenges;

import java.util.*;
import java.util.Queue;

public class ReverseSpiral {

    public static int[] reverseSpiral(int R, int C, int[][] a) {

        int n = R * C;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int numbers = 0, i = 0, j = 0, spiral = 0;
        boolean right = true, down = false, left = false;
        while (numbers < n) {
            System.out.print(" " + a[i][j]);
            stack.add(a[i][j]);
            numbers++;
            if (right) {
                if (j + 1 < (C - spiral)) {
                    j++;
                } else {
                    i++;
                    down = true;
                    right = false;
                }
                continue;
            }

            if (down) {
                if (i + 1 < R - spiral) {
                    i++;
                } else {
                    j--;
                    left = true;
                    down = false;
                }
                continue;
            }

            if (left) {
                if (j - 1 >= spiral) {
                    j--;
                } else {
                    i--;
                    left = false;
                }
                continue;
            }

            if (i - 1 >= spiral + 1) {
                i--;
            } else {
                j++;
                right = true;
                spiral++;
            }
        }

        i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] a = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
//        int R = 3, C = 3;

//        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int R = 4, C = 4;


        int R = 8, C = 7;
        int[][] a = {
                {13, 14, 13, 4, 7, 14, 16},
                {6, 16, 15, 20, 12, 5, 18},
                {19, 19, 18, 4, 9, 16, 14},
                {11, 15, 13, 15, 6, 1, 10},
                {9, 19, 6, 8, 16, 8, 2},
                {5, 19, 16, 17, 5, 18, 12},
                {10, 1, 16, 2, 6, 6, 1},
                {20, 18, 4, 2, 15, 6, 20}};
        System.out.println(Arrays.toString(reverseSpiral(R, C, a)));
    }
}
