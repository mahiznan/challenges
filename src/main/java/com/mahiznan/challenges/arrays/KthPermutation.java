package com.mahiznan.challenges.arrays;

public class KthPermutation {

    static int count = 0, target = 6;


    static void printAllPermutationsPractice(int[] ar,int l,int r) {
        if (l == r) {
            printArray(ar);
        }
        for(int i=l;i<=r;i++){
            swap(ar,l,i);
            printAllPermutationsPractice(ar,l+1,r);
            swap(ar,l,i);
        }
    }

    static void printAllPermutations(int[] values, int l, int r) {
        if (l == r) {
            printArray(values);
        }
        for (int i = l; i <= r; i++) {
            swap(values, l, i);
            printAllPermutations(values, l + 1, r);
            swap(values, l, i);
        }
    }

    static void printKthPermutation(int[] values, int l, int r) {
        if (l == r) {
//            System.out.println("Current value is " + count);
//            printArray(values);
            count += 1;
            if (count == target) {
                printArray(values);
            }
        }
        for (int i = l; i <= r; i++) {
            swap(values, l, i);
            printKthPermutation(values, l + 1, r);
            swap(values, l, i);
        }
    }

    static void swap(int[] values, int i, int j) {
        int t = values[i];
        values[i] = values[j];
        values[j] = t;
    }

    static void printArray(int[] values) {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int p = 6;
        printAllPermutationsPractice(values, 0, values.length - 1);
//        printAllPermutations(values, 0, values.length - 1);
//        printKthPermutation(values, 0, values.length - 1);
    }
}
