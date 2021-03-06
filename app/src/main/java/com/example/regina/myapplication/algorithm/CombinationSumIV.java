package com.example.regina.myapplication.algorithm;


//377. Combination Sum IV
//        Medium
//
//        743
//
//        73
//
//        Favorite
//
//        Share
//        Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
//        Example:
//
//        nums = [1, 2, 3]
//        target = 4
//
//        The possible combination ways are:
//        (1, 1, 1, 1)
//        (1, 1, 2)
//        (1, 2, 1)
//        (1, 3)
//        (2, 1, 1)
//        (2, 2)
//        (3, 1)
//
//        Note that different sequences are counted as different combinations.
//
//        Therefore the output is 7.



public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1;i <= target ;i++ ) {
            for (int k : nums) {
                if (k <= i)
                    dp[i] += dp[i - k];
            }
        }
        return dp[target];
    }
}
