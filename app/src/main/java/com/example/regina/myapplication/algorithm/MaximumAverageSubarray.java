package com.example.regina.myapplication.algorithm;


//868. Maximum Average Subarray
//        中文English
//        Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. You need to output the maximum average value.
//
//        Example
//        Example1
//
//        Input:  nums = [1,12,-5,-6,50,3] and k = 4
//        Output: 12.75
//        Explanation:
//        Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//        Example2
//
//        Input:  nums = [4,2,1,3,3] and k = 2
//        Output: 3.00
//        Explanation:
//        Maximum average is (3+3)/2 = 6/2 = 3.00
//        Notice
//        1 <= k <= n <= 30,000.
//        Elements of the given array will be in the range [-10,000, 10,000].




public class MaximumAverageSubarray {
    public class Solution {
        /**
         * @param nums: an array
         * @param k: an integer
         * @return: the maximum average value
         */
        public double findMaxAverage(int[] nums, int k) {
            // Write your code here
            if (nums == null || nums.length < k) {
                return 0.0;
            }

            int len = nums.length;
            long sum = 0L;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            long max = sum;
            for (int i = k; i < len; i++) {
                sum += nums[i];
                sum -= nums[i - k];
                max = Math.max(max, sum);
            }

            return ((double)max / k);
        }

//        public double findMaxAverage(int[] nums, int k) {
//            // Write your code here
//            int n = nums.length;
//            int[] sum = new int[n + 1];
//            for(int i = 1; i <= n; i++){
//                sum[i] = sum[i - 1] + nums[i - 1];
//            }
//            int ans = Integer.MIN_VALUE;
//            for(int i = k; i <= n; i++){
//                ans = Math.max(ans, sum[i] - sum[i - k]);
//            }
//            return ans * 1.0 / k;
//        }


    }

}
