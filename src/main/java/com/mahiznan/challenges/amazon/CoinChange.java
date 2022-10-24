package com.mahiznan.challenges.amazon;

/*
How many ways can you make change with coins and a total amount
Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
We can make changes in 6 ways:

Ex 1
Input: sum = 4, coins[] = {1,2,3},
Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.

Ex 2
Input: sum = 10, coins[] = {2, 5, 3, 6}
Output: 5
Explanation: There are five solutions:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
public class CoinChange {
    private static int countWaysRecursive(int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;
        if (n < 1)
            return 0;
        if (sum < 0)
            return 0;
        return countWaysRecursive(coins, n - 1, sum) + countWaysRecursive(coins, n, sum - coins[n - 1]);
    }


    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
//        int[] coins = {1, 2, 3};
//        int sum = 4;
//        System.out.println(countWaysRecursive(coins, coins.length, sum));
        System.out.println(countWaysDP(coins, sum));
    }

    private static int countWaysDP(int[] coins, int sum) {
        int[] table = new int[sum + 1];
        table[0] = 1;
        for (int coin : coins) {
            for (int amount = coin; amount <= sum; amount++) {
                table[amount] += table[amount - coin];
            }
        }
        return table[sum];
    }
}
