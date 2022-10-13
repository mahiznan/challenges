package com.mahiznan.challenges;

import java.util.ArrayList;

public class CountSmallerElements {


    static int count(int x, int n, ArrayList<Integer> al) {
        int low = 0, high = n - 1, ans = -1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (al.get(mid) < x) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        al.add(ans + 1, x);
        return ans + 1;
    }

    static int[] constructLowerArrayApproach2(int[] arr, int n) {
        int[] ans = new int[n];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--)
            ans[i] = count(arr[i], n - i - 1, al);
        return ans;
    }

    static int[] constructLowerArray(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 7;
        int[] arr = {12, 1, 2, 3, 0, 11, 4};
//        int n = 5;
//        int[] arr = {1, 2, 3, 4, 5};
        int[] result = constructLowerArrayApproach2(arr, n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
