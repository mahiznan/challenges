package com.mahiznan.challenges;

public class TrailingZeros {
    public static void main(String[] args) {
        int N = 384;
        System.out.println(trailingZeros(N));
    }

    private static int trailingZeros(int N) {
        int count = 0;
        for (int i = 5; N / i >= 1; i *= 5)
            count += N / i;
        return count;
    }
}
