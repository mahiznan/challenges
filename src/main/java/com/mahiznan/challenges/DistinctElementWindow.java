package com.mahiznan.challenges;

import java.util.*;

public class DistinctElementWindow {

    public static void main(String[] args) {
        int N = 7, K = 4;
        int[] A = {1, 2, 1, 3, 4, 2, 3};
//        System.out.println(countDistinct(A, N, K));
        System.out.println(countDistinctApproach2(A, N, K));

    }

    //Approach 1
    static ArrayList<Integer> countDistinct(int[] A, int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> data = new HashSet<>();

        for (int i = 0, p = 0; i < n; ) {
            data.add(A[i]);
            p++;
            if (p % k == 0) {
                res.add(data.size());
                data.clear();
                i = i - k + 2;
                p = 0;
            } else {
                i++;
            }
        }
        return res;
    }

    //Approach 2 - Efficient
    static ArrayList<Integer> countDistinctApproach2(int[] arr, int n, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        // {1, 2, 1, 3, 4, 2, 3};
        for (int i = 0; i < k; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        ans.add(m.size());
        int last = 0;

        for (int i = k; i < n; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            int temp = arr[last++];
            if (m.get(temp) > 1) {
                m.put(temp, m.get(temp) - 1);
            } else {
                m.remove(temp);
            }
            ans.add(m.size());
        }
        return ans;
    }

}
