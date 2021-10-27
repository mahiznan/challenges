package com.mahiznan.challenges.arrays;

public class AllPermutation {

    public static void printAllPermutationPractice(char[] chars, int l, int r) {
        if (l == r) {
            System.out.println(new String(chars));
        }

        for (int i = l; i <= r; i++) {
            swap(chars, i, l);
            printAllPermutationPractice(chars, l + 1, r);
            swap(chars, i, l);
        }

    }

    public static void main(String[] args) {
        String s = "rajesh";
//        printAllPermutation(s.toCharArray(), 0, s.length() - 1);
        printAllPermutationPractice(s.toCharArray(), 0, s.length() - 1);
    }

    private static void printAllPermutation(char[] chars, int l, int r) {
        if (l == r)
            System.out.println(new String(chars));

        for (int i = l; i <= r; i++) {
            swap(chars, l, i);
            printAllPermutation(chars, l + 1, r);
            swap(chars, l, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
