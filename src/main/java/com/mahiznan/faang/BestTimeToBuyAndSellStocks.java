package com.mahiznan.faang;

/*
You are given an array prices where prices[i] denotes the price of a stock on the ith day. You want to maximize the profit by buying a stock and then selling it at a higher price.

Suppose you can make a single buy and single sell at any date after you buy, what is the maximum profit that you can make?

Note: Return 0 if you cannot make a profit.

Examples
prices: [6, 1, 4, 2, 5, 3]
Answer: 4

Explanation
Buy on day 2 (price: 1) and Sell on day 5 (price: 5).
Profit: 5 - 1 = 4.
prices: [5, 4, 3, 2, 1]
Answer: 0

Explanation
No transactions that can give a profit.
Testing
Input Format
The first line contains an integer ‘T’ denoting the number of test cases.
For each test case, the input has two lines:

An integer ‘n’ denoting the size of the array.
n space-separated integers denoting the array.
Output Format
For each test case, the output contains a line with one integer denoting the max profit.

Sample Input
2
6
6 1 4 2 5 3
5
5 4 3 2 1
Expected Output
4
0
Constraints
1 <= T <= 100
1 <= n <= 104
1 <= prices[i] <= 1000
 */
public class BestTimeToBuyAndSellStocks {

    int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - buyPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }


    int maxProfitOptimal(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks solution = new BestTimeToBuyAndSellStocks();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{6, 1, 4, 2, 5, 13}));
        System.out.println(solution.maxProfit(new int[]{5, 4, 3, 2, 1}));
    }
}
