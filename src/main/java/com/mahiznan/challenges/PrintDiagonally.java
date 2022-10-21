package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.
 */
public class PrintDiagonally {

    static ArrayList<Integer> downwardDiagonal(int N, int[][] A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (map.containsKey(i + j)) {
                    ArrayList<Integer> temp = map.get(i + j);
                    temp.add(A[i][j]);
                    map.put(i + j, temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A[i][j]);
                    map.put(i + j, temp);
                }
        }


        int i = 0;
        while (map.containsKey(i)) {
            result.addAll(map.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(downwardDiagonal(N, A));
    }
}
