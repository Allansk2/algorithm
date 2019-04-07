package com.example.regina.myapplication.algorithm;

//
//41. Maximum Subarray
//        中文English
//        Given an array of integers, find a contiguous subarray which has the largest sum.
//
//        Example
//        Example1:
//        Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
//        Example2:
//        Given the array [1,2,3,4], the contiguous subarray [1,2,3,4] has the largest sum = 10.
//
//        Challenge
//        Can you do it in time complexity O(n)?
//
//        Notice
//        The subarray should contain at least one number.


public class MaximumSubarray {
    public class Solution {
        // version 1 dy
        public int maxSubArray(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }


//        // Version 2: Greedy
//        public int maxSubArray(int[] A) {
//            if (A == null || A.length == 0){
//                return 0;
//            }
//            int max = Integer.MIN_VALUE, sum = 0;
//            for (int i = 0; i < A.length; i++) {
//                sum += A[i];
//                max = Math.max(max, sum);
//                sum = Math.max(sum, 0);
//            }
//
//            return max;
//        }
//

    }
}
