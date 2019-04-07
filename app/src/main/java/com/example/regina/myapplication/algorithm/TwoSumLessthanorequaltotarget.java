package com.example.regina.myapplication.algorithm;


//609. Two Sum - Less than or equal to target
//        中文English
//        Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
//
//        Example
//        Example 1:
//
//        Input: nums = [2, 7, 11, 15], target = 24.
//        Output: 5.
//        Explanation:
//        2 + 7 < 24
//        2 + 11 < 24
//        2 + 15 < 24
//        7 + 11 < 24
//        7 + 15 < 25
//        Example 2:
//
//        Input: nums = [1], target = 1.
//        Output: 0.

import java.util.Arrays;

public class TwoSumLessthanorequaltotarget {
    public class Solution {
        /**
         * @param nums: an array of integer
         * @param target: an integer
         * @return: an integer
         */
        public int twoSum5(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int count = 0;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }

                if (left < right) {
                    count += right - left;
                }
                left++;
            }

            return count;
        }
    }
}
