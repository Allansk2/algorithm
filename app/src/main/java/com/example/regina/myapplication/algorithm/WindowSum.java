package com.example.regina.myapplication.algorithm;

//604. Window Sum
//        中文English
//        Given an array of n integers, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.
//
//        Example
//        Example 1
//
//        Input：array = [1,2,7,8,5], k = 3
//        Output：[10,17,20]
//        Explanation：
//        1 + 2 + 7 = 10
//        2 + 7 + 8 = 17
//        7 + 8 + 5 = 20

public class WindowSum {

    public class Solution {

        public int[] winSum(int[] nums, int k) {
            // write your code here
            if (nums == null || nums.length < k || nums.length == 0 || k <= 0) {
                return new int[0];
            }

            int[] sumArray = new int[nums.length - k + 1];
            int i = 0, j = k - 1;
            int sum = 0;
            for (int index = 0; index < k; index++) {
                sum += nums[index];
            }
            sumArray[i] = sum;
            i++;
            j++;

            while (j < nums.length) {
                sumArray[i] = sumArray[i - 1] - nums[i - 1] + nums[j];
                i++;
                j++;
            }

            return sumArray;
        }
    }
}
