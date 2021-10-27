package com.mahiznan.challenges;

public class CountBits {


    public static void main(String[] args) {
        int n = 111;
        System.out.println("No of 1 bit is " + calculateBits(n));
        System.out.println("No of 1 bit is via recursive approach " + calculateBitsRecursive(n));
        System.out.println("No of 1 bit is via built in approach " + Integer.bitCount(n));

    }

    private static int calculateBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    private static int calculateBitsRecursive(int n) {
        if (n == 0)
            return 0;
        return (n & 1) + calculateBits(n >> 1);
    }

}
