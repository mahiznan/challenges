package com.mahiznan.challenges.amazon;

public class FillingBucket {
    public static void main(String[] args) {
        int N = 8223;
        System.out.println(fillingBucket(N));
    }

    static int fillingBucket(int N) {
        if (N < 3)
            return N;
        int prev1 = 2, prev2 = 1;

        for (int i = 3; i <= N; i++) {
            int curr = (prev1 % 100000000 + prev2 % 100000000) % 100000000;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }


}
