package com.mahiznan.challenges;

public class MinMaxSum {
    public static void main(String[] args) {
        int[] A = {-2, 1, -4, 5, 3};
        System.out.print(findSum(A, A.length));
    }

    public static int findSum(int A[], int N) {
        int min = A[0], max = A[0];

        for (int i = 1; i < N; i++) {
            if (min > A[i])
                min = A[i];
            if (max < A[i])
                max = A[i];
        }
        return min + max;
    }
}
