package com.example.regina.myapplication.algorithm;


//149. Best Time to Buy and Sell Stock
//        中文English
//        Say you have an array for which the ith element is the price of a given stock on day i.
//
//        If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//        Example
//        Given array [3,2,3,1,2], return 1.


public class BestTimetoBuyandSellStock {
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int min = Integer.MAX_VALUE;  //just remember the smallest price
            int profit = 0;
            for (int i : prices) {
                min = i < min ? i : min;
                profit = (i - min) > profit ? i - min : profit;
            }

            return profit;
        }
    }

}
