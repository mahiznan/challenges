package com.mahiznan.challenges;

import java.util.Arrays;

public class MaximizeToys {
    static int toyCount(int N, int K, int[] arr) {
        Arrays.sort(arr);
        int toysCount = 0;
        for (int price : arr) {
            if (K >= price) {
                toysCount++;
                K -= price;
            } else {
                break;
            }
        }

        return toysCount;
    }

    public static void main(String[] args) {
        int K = 50;
        int[] arr = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println(toyCount(arr.length, K, arr));
    }
}
