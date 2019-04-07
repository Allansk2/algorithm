package com.example.regina.myapplication.algorithm;

//151. Best Time to Buy and Sell Stock III
//        中文English
//        Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//        Example
//        Given an example [4,4,6,1,1,4,2,5], return 6.
//
//        Notice
//        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class BestTimetoBuyandSellStockIII {

    public class Solution {
        /**
         * @param prices: Given an integer array
         *
         * @return: Maximum profit
         */
        public int maxProfit(int[] prices) {
            // write your code here
            if (prices == null || prices.length <= 1) {
                return 0;
            }

            int len = prices.length;
            int[] left = new int[len];
            int[] right = new int[len];

            //dp from left to right
            left[0] = 0;
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, prices[i]);
                left[i] = Math.max(left[i - 1], prices[i] - min);
            }

            right[len - 1] = 0;
            int max = prices[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                max = Math.max(max, prices[i]);
                right[i] = Math.max(right[i + 1], max - prices[i]);
            }

            int profit = 0;
            for (int i = 0; i < len; i++) {
                profit = Math.max(profit, left[i] + right[i]);
            }

            return profit;
        }
    }
}
