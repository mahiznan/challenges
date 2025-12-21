package com.mahiznan.faang;

    import java.util.*;

public class DistinctNumberInWindow {

    int[] distinctNumbersInWindow(int[] A, int k) {
        int n = A.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        int distinct = 0;

        // First window
        for (int i = 0; i < k; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 1) {
                distinct++;
            }
        }

        result[0] = distinct;

        // Slide the window
        for (int i = k; i < n; i++) {
            int out = A[i - k];
            int in = A[i];

            // Remove outgoing
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                distinct--;
            }

            // Add incoming
            map.put(in, map.getOrDefault(in, 0) + 1);
            if (map.get(in) == 1) {
                distinct++;
            }

            result[i - k + 1] = distinct;
        }

        return result;
    }

    ArrayList<Integer> countDistinct(int A[], int k) {
        int n = A.length;
        ArrayList<Integer> result = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();

        int distinct = 0;

        // First window
        for (int i = 0; i < k; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 1) {
                distinct++;
            }
        }

        result.add(distinct);

        // Slide the window
        for (int i = k; i < n; i++) {
            int out = A[i - k];
            int in = A[i];

            // Remove outgoing
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                distinct--;
            }

            // Add incoming
            map.put(in, map.getOrDefault(in, 0) + 1);
            if (map.get(in) == 1) {
                distinct++;
            }


            result.add(distinct);
        }

        return result;

    }


    public static void main(String[] args) {
        int[] A = {1, 1, 2, 1, 4, 6, 5};
        int k = 3;
        DistinctNumberInWindow obj = new DistinctNumberInWindow();
//        int[] result = obj.distinctNumbersInWindow(A, k);
//        System.out.println(Arrays.toString(result));
        ArrayList<Integer> result = obj.countDistinct(A, k);
        System.out.println(result);


    }
}


