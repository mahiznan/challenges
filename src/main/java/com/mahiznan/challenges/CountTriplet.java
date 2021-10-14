package com.mahiznan.challenges;

import java.util.Arrays;

public class CountTriplet {

    //Approach 1
    static long countTriplets1(long[] arr, int n, int sum) {
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum)
                        r++;
                }
            }
        }
        return r;
    }

    static long countTriplets(long[] arr, int n, int sum) {
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < sum) {
                    res += (k - j);
                    j = j + 1;
                } else if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        long[] arr = {-2, 0, 1, 3};
        int n = arr.length;
        int sum = 2;
//        System.out.println(countTriplets1(arr, n, sum));
        System.out.println(countTriplets(arr, n, sum));
    }
}
