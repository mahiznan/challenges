package com.mahiznan.challenges;

import java.util.HashSet;
import java.util.Set;

class NextSmallestNo {

    public static int solution(int[] A) {
        int N = A.length, res = 1;
        boolean found = false;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1 && !found; i++) {
            if (!set.contains(i)) {
                res = i;
                found = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] A = {-1, -3};
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));



    }
}