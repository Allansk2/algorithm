package com.example.regina.myapplication.algorithm;


//533. Two Sum - Closest to target
//        中文English
//        Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
//
//        Return the absolute value of difference between the sum of the two integers and the target.
//
//        Example
//        Example1
//
//        Input:  nums = [-1, 2, 1, -4] and target = 4
//        Output: 1
//        Explanation:
//        The minimum difference is 1. (4 - (2 + 1) = 1).
//        Example2
//
//        Input:  nums = [-1, -1, -1, -4] and target = 4
//        Output: 6
//        Explanation:
//        The minimum difference is 6. (4 - (- 1 - 1) = 6).
//        Challenge
//        Do it in O(nlogn) time complexity.

import java.util.Arrays;

public class TwoSumClosesttotarget {

    public class Solution {
        /**
         * @param nums: an integer array
         * @param target: An integer
         * @return: the difference between the sum and the target
         */
        public int twoSumClosest(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            Arrays.sort(nums);
            int left = 0, right = nums.length -1;
            int ans = Integer.MAX_VALUE;
            while (left < right) {
                while (left < right && nums[left] + nums[right] > target) {
                    ans = Math.min(ans, Math.abs(target - nums[left] - nums[right]));
                    right--;
                }

                if (left < right) {
                    ans = Math.min(ans, Math.abs(target - nums[left] - nums[right]));
                }
                left++;
            }

            return ans;
        }
    }

}
