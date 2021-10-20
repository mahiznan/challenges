package com.mahiznan.challenges;

import java.util.HashMap;
import java.util.HashSet;

public class PrintAllSubSet {

    final static HashMap<Integer, HashSet<Integer>> result = new HashMap<>();

    static void print(int[] array, HashSet<Integer> subSet) {
        if (!subSet.isEmpty()) {
            int sum = subSet.stream().mapToInt(a -> a).sum();
            //System.out.println("Sum is " + sum);
            if (result.get(sum) == null) {
                System.out.println(subSet);
                result.putIfAbsent(sum, subSet);
            }
        }
        for (int j : array) {
            if (!subSet.contains(j)) {
                subSet.add(j);
                print(array, subSet);
                subSet.remove(j);
            }
        }

    }

    static void printArray(int[] values) {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        final HashSet<Integer> subSet = new HashSet<>();
        int[] set = {1, 2, 3, 4};
        print(set, subSet);
        /*for (Map.Entry<Integer, HashSet<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
    }
}
