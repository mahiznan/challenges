package com.mahiznan.challenges.amazon;

import java.util.ArrayList;

public class MaxOfAllSubArrays {
    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (arr[i] > currentMax)
                currentMax = arr[i];
        }
        res.add(currentMax);
        for (int i = k; i < n; i++) {
            System.out.println("Range " + ((i - k) + 1) + " to " + i);
            currentMax = arr[(i - k) + 1];
            for (int j = (i - k) + 1; j <= i; j++) {
                if (arr[j] > currentMax)
                    currentMax = arr[j];
            }
            res.add(currentMax);
        }
        return res;
    }

    static ArrayList<Integer> max_of_subarraysApproach2(int[] arr, int n, int k) {
        ArrayList<Integer> max = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int index = i, greator = arr[index];//8
            while (index < (i + k - 1)) {
                if (greator < arr[index + 1]) {
                    greator = arr[index + 1];
                }
                index++;
            }
            max.add(greator);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int n = arr.length;
        int k = 3;
        System.out.println(max_of_subarraysApproach2(arr, n, k));
    }
}

