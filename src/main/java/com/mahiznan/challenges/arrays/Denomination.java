package com.mahiznan.challenges.arrays;

import java.util.List;

public class Denomination {
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    //Approach 1 - Recursive
    static int solveCoinChange(int[] coins, int totalSum, List<Integer> wallet, int result) {
        if (sum(wallet) == totalSum) {
            System.out.println(wallet);
            wallet.remove(wallet.size() - 1);
            return 1;
        } else if (sum(wallet) > totalSum) {
            wallet.remove(wallet.size() - 1);
            return 0;
        }
        for (int coin : coins) {
            wallet.add(coin);
            result += solveCoinChange(coins, totalSum, wallet, result);
            wallet.remove(wallet.size() - 1);
        }
        return result;
    }

    //Approach 2 Dynamic Programming
    static int solveCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {9, 5, 3, 1};
        int totalSum = 14;

//        System.out.println(possibleWays(coins, totalSum, new ArrayList<>(), 0));
        System.out.println(solveCoinChange(coins, totalSum));
    }
}
