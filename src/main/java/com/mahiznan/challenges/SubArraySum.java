package com.mahiznan.challenges;


import java.util.ArrayList;

public class SubArraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        /*
        int N = 42, S = 468;
        int[] A = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146,
                82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154,
                93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113,
                68, 100, 36, 95, 104, 12, 123, 134, 38, 42};
        */
        /*
        int N = 5, S = 12;
        int[] A = {1, 2, 3, 7, 5};
        */
        ArrayList<Integer> result = new ArrayList<>();
        int sum = arr[0], sp = 0, ep = 0;
        for (int i = 1; sp < n; i++) {
            if (sum == s) {
//                System.out.println("Got result" + s);
                result.add(sp + 1);
                result.add(i - ep);
                break;
            } else if (sum > s) {
//                System.out.println("Sum is " + sum + "; INDEX POSITION " + sp + " to " + (i - 1));
                sum -= arr[sp];
                if (sum == s) {
//                    System.out.println("Got result inside" + s);
                    result.add(sp + 2);
                    result.add(i - ep);
                    break;
                }

                if (i < n) {
                    sum += arr[i];
                } else {
                    ep++;
                }
                sp++;
            } else {
//                System.out.println("Sum is " + sum);
                sum += arr[i];
            }

        }
        if (result.size() == 0)
            result.add(-1);
        return result;
    }

    public static void main(String[] args) {
//        int N = 5, S = 12;
//        int[] A = {1, 2, 3, 7, 5};
//        int N = 10, S = 15;
//        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = 42, S = 468;
        int[] A = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146,
                82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154,
                93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113,
                68, 100, 36, 95, 104, 12, 123, 134, 38, 42};
        //38 42

        System.out.println(subarraySum(A, N, S));

        /*
        Output: 2 4
        Explanation: The sum of elements
        from 2nd position to 4th position
        is 12.
            */

    }
}
