package com.mahiznan.challenges;

public class MinCostToPaint {

    static int minimumCost = Integer.MAX_VALUE;

    //Recursive Approach O(3^N)
    static void paint(int[][] cost, int houseCount, int totalHouses, int[] res) {
        if (houseCount >= totalHouses) {
            int currentCost = 0;
            for (int i = 0; i < cost.length; i++)
                currentCost += cost[i][res[i]];
            minimumCost = Math.min(currentCost, minimumCost);
        }

        for (int i = houseCount; i < totalHouses; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                if (houseCount == 0 || res[i - 1] != j) {
                    res[i] = j;
                    paint(cost, houseCount + 1, totalHouses, res);
                }
            }
        }
    }

    //Dynamic Programming
    static int minCostDP(int[][] cost, int N) {

        if (N == 0)
            return 0;
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        return Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

    }


    public static void main(String[] args) {
        //Test case 1
        int N = 3;
        int[][] cost = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};

        //Test case 2
//        int N = 2;
//        int[][] cost = {{1, 2, 3}, {1, 4, 6}};

//        int N = 10;
//        int[][] cost = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}, {14, 2, 11}, {11, 14, 5}, {14, 3, 10}, {14, 2, 11}, {11, 14, 5}, {14, 3, 10}, {14, 2, 11}};


        /*
            int[] res = new int[N];
            paint(cost, 0, N, res);
            System.out.println(minimumCost);
        */
        System.out.println(minCostDP(cost, N));
    }
}
