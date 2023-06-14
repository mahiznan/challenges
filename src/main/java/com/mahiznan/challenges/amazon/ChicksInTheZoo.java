package com.mahiznan.challenges.amazon;

/*
Initially, the zoo have a single chick.
A chick gives birth to 2 chicks every day and the life expectancy of a chick is 6 days.
Zoo officials want to buy food for chicks so they want to know the number of chicks on an Nth day. Help the officials with this task.

Example 1

Input: N = 2
Output: 3
Explanation: First day there is only 1 chick.
On second day total number of chicks = 3.

Example 2

Input: N = 3
Output: 9
Explanation: First day there is only 1 chick.
On second day total number of chicks = 3.
On third day total number of chicks = 9

 */
public class ChicksInTheZoo {

    static long noOfChicks(int N) {
        if (N < 7)
            return (long) Math.pow(3, N - 1);
        return (long) (Math.pow(3, N - 1) - Math.pow(3, N - 6));
    }

    static long noOfChicksApproach2(int N) {
        long[] chicks = new long[N];
        long[] check = new long[N];

        chicks[0] = 1;
        check[0] = 1;

        long sum = 1;

        for (int i = 1; i < N; i++) {
            if (i >= 6) check[i] -= check[i - 6];
            check[i] = (check[i - 1] * 2) + check[i - 1];
            System.out.println("At day " + (i + 1) + " - " + check[i]);
        }

        for (int i = 1; i < N; i++) {
            if (i >= 6) sum -= chicks[i - 6];
            chicks[i] = 2 * sum;
            sum += chicks[i];
            System.out.println("At day " + (i + 1) + " - " + sum);
        }
        return sum;
    }


    public static void main(String[] args) {
        int N = 10;
        System.out.println(noOfChicksApproach2(N));
        //2172

    }
}
