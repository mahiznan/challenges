package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.Arrays;

public class FarthestNumber {
    public static ArrayList<Integer> farNumber(int N, int[] A) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    found = true;
                    al.add(j);
                    break;
                }
            }
            if (!found)
                al.add(-1);
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int N = 5;
//        int[] Arr = {3, 1, 5, 2, 4};
        int[] Arr = {1, 2, 3, 4, 0};
        System.out.println(farNumber(N, Arr));
    }
}
