package com.mahiznan.challenges;

public class EquilibriumPoint {
    public static int equilibriumPoint(long[] arr, int n) {
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            rightSum = rightSum - arr[i];
            if (leftSum == rightSum)
                return i + 1;
            leftSum += arr[i];
        }
        return -1;
    }


    public static void main(String[] args) {
//        long[] arr = {1};
        long[] arr = {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }
}
