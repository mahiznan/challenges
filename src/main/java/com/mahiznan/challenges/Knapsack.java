package com.mahiznan.challenges;

public class Knapsack {


    static int knapsackDPPractice(int[] weight, int[] value, int capacity, int size) {
        if (size == 0 || capacity == 0) {
            return 0;
        }

        int[][] dp = new int[size + 1][capacity + 1];

        for (int i = 0; i <= size; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][weight[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][weight[i - 1]];
                }
            }
        }
        return dp[size][capacity];
    }


    static int knapsackDP(int capacity, int[] weight, int[] value, int size) {

        int[][] k = new int[size + 1][capacity + 1];

        for (int i = 0; i <= size; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (weight[i - 1] <= w) {
                    k[i][w] = Math.max(value[i - 1] + k[i - 1][w - weight[i - 1]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }
        return k[size][capacity];
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int totalCapacity = 50;
//        System.out.println(knapsack(value, weight, totalCapacity, value.length - 1));
        System.out.println(knapsackDPPractice(weight, value, totalCapacity, value.length));
    }

    private static int knapsack(int[] value, int[] weight, int capacity, int size) {
        System.out.println("Getting value for " + capacity + " from size " + size);
        if (size == 0 || capacity == 0)
            return 0;

        if (weight[size] > capacity)
            return knapsack(value, weight, capacity, size - 1);

        return Math.max(knapsack(value, weight, capacity - weight[size], size - 1) + value[size],
                knapsack(value, weight, capacity, size - 1)
        );

    }
}
