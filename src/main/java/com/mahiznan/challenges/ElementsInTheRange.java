package com.mahiznan.challenges;

import java.util.Arrays;

public class ElementsInTheRange {
//todo not working for the given example
    static boolean check_elements(int[] arr, int n, int A, int B) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == A && (i + (B - A) < n) && arr[i + (B - A)] == B) {
                System.out.println(arr[i]);
                System.out.println(arr[i + (B - A)]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int N = 7, A = 2, B = 5;
//        int[] arr = {1, 4, 5, 2, 7, 8, 3};
//        int N = 7, A = 2, B = 6;
//        int[] arr = {1, 4, 5, 2, 7, 8, 3};

        int N = 44, A = 5, B = 7;
        int[] arr = {4, 9, 2, 9, 3, 6, 5, 3, 7, 8, 1, 2, 9, 2, 9, 9, 6, 4, 3, 10, 10, 8, 9, 10, 3, 5, 9, 3, 4, 4, 5, 5, 6, 10, 5, 2, 5, 6, 8, 4, 5, 5, 7, 4};

        System.out.println(check_elements(arr, N, A, B));
    }
}
