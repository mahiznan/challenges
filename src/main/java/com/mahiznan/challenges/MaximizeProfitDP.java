package com.mahiznan.challenges;

public class MaximizeProfitDP {

    static int getMaxProfit(int pos, int[] prices, int fee, boolean bought) {
        System.out.println("Calling " + pos + " Bought " + bought);
        if (pos == prices.length) {
            return 0;
        }
        int maxProfit = 0;

        if (!bought) {
//            System.out.println("Buying at " + pos);
            maxProfit = Math.max(maxProfit, getMaxProfit(pos + 1, prices, fee, true) - prices[pos] - fee);
//            System.out.println("Profit while buying at " + pos + " -> " + maxProfit);
        } else {
//            System.out.println("Selling at " + pos);
            maxProfit = Math.max(maxProfit, getMaxProfit(pos + 1, prices, fee, false) + prices[pos]);
//            System.out.println("Profit while selling at " + pos + " -> " + maxProfit);

        }
//        System.out.println("Doing nothing at " + pos);
        maxProfit = Math.max(maxProfit, getMaxProfit(pos + 1, prices, fee, bought));
//        System.out.println("Max Profit at " + pos + " -> " + maxProfit);
        return maxProfit;
    }


    static int maxProfit(int[] prices, int fee) {

        return getMaxProfit(0, prices, fee, false);
    }

    public static void main(String[] args) {
//        int[] prices = {1, 3, 2, 8, 4, 9};
//        int fee = 2;
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }
}
