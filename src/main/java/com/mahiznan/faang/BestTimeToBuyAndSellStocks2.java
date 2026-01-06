package com.mahiznan.faang;

/*
You are given an array prices where prices[i] denotes the price of a stock on the ith day. You want to maximize the profit by buying a stock and then selling it at a higher price.

Suppose you can do as many transactions as you want, what is the maximum profit that you can make?

Note:

Return 0 if you cannot make a profit.
You cannot buy/hold more than 1 stock at a time.
You need to sell a stock before buying again.
You can sell a stock and buy it again on the same day.
Examples
prices: [6, 1, 4, 2, 5, 3]
Answer: 6

Explanation
Buy on day 2 (price: 1) and Sell on day 3 (price: 4).
Buy on day 4 (price: 2) and Sell on day 5 (price: 5).
Profit: (4 - 1) + (5 - 2) = 6.
prices: [1, 2, 3, 4, 5]
Answer: 4

Explanation
Buy on day 1 (price: 1) and Sell on day 5 (price: 5).
Profit: (5 - 1) = 4.
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
1 2 3 4 5
Expected Output
6
4
Constraints
1 <= T <= 100
1 <= n <= 104
1 <= pricesi <= 1000


 */

// 9,1,4,2,5,3
public class BestTimeToBuyAndSellStocks2 {
    int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > start)
                maxProfit += prices[i] - start;
            start = prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks2 s = new BestTimeToBuyAndSellStocks2();
//        System.out.println(s.maxProfit(new int[]{9, 1, 4, 2, 5, 3}));
        System.out.println(s.maxProfit(new int[]{1, 50, 100}));
    }
}
