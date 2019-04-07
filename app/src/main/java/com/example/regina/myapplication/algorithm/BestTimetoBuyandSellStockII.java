package com.example.regina.myapplication.algorithm;


//150. Best Time to Buy and Sell Stock II
//        中文English
//        Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//
//        Example
//        Given an example [2,1,2,0,1], return 2


public class BestTimetoBuyandSellStockII {

    public class Solution {
        /**
         * @param prices: Given an integer array
         * @return: Maximum profit
         */
        public int maxProfit(int[] prices) {
            // write your code here
            if (prices == null || prices.length <= 1) {
                return 0;
            }

            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }

            return profit;
        }
    }

}
