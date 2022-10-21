package com.mahiznan.challenges;


import java.util.ArrayList;

public class SubArraySum {
    public static void main(String[] args) {
//        int N = 5, S = 12;
//        int[] A = {1, 2, 3, 7, 5};
//        int N = 10, S = 15;
//        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int N = 42, S = 468;
//        int[] A = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146,
//                82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154,
//                93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113,
//                68, 100, 36, 95, 104, 12, 123, 134};
        //38 42

        int N = 4, S = 0;
        int[] A = {1, 2, 3, 4};
//        int N = 74, S = 665;
//        int[] A = {142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142, 142};

        System.out.println(subarraySum(A, N, S));

        /*
        Output: 2 4
        Explanation: The sum of elements
        from 2nd position to 4th position
        is 12.
            */

    }

    private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int startIndex = 0, endIndex = 0, total = arr[0];
        if (s == 0) {
            res.add(-1);
            return res;
        }
        while (total != s && startIndex < arr.length) {
            if (total < s && endIndex + 1 < arr.length) {
                endIndex++;
                total += arr[endIndex];
                continue;
            }
            if (startIndex + 1 <= arr.length) {
                total -= arr[startIndex];
                startIndex++;
            }
        }
        if (total == s) {
            res.add(startIndex + 1);
            res.add(endIndex + 1);
        } else {
            res.add(-1);
        }
        return res;

    }
}
