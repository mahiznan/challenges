package com.mahiznan.challenges;

public class TotalCuts {
    public static int totalCuts(int N, int K, int[] A) {
        int cuts = 0;
        for (int i = 1; i < N; i++) {
//            System.out.println("Cut Position at " + i);
            int leftMax = -1;
            for (int lp = 0; lp < i; lp++) {
                if (A[lp] > leftMax)
                    leftMax = A[lp];
            }
//            System.out.println("Left Max " + leftMax);

            int rightMin = Integer.MAX_VALUE;
            for (int rp = i; rp < N; rp++) {
                if (A[rp] < rightMin)
                    rightMin = A[rp];
            }
//            System.out.println("Right Min " + rightMin);
            if (leftMax + rightMin >= K) {
                cuts++;
            }
        }

        return cuts;
    }

    public static void main(String[] args) {
//        int N = 3;
//        int K = 3;
//        int[] A = {1, 2, 3};

        int N = 5;
        int K = 5;
        int[] A = {1, 2, 3, 4, 5};

        System.out.println(totalCuts(N, K, A));
    }
}
