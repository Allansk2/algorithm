package com.example.regina.myapplication.algorithm;

/**
 * Created by Allan Zhu on 2019-04-07.
 */
public class MaximumSubarrayIII {

    public class Solution {

        /**
         * @param nums: A list of integers
         * @param k:    An integer denote to find k non-overlapping subarrays
         *
         * @return: An integer denote the sum of max k non-overlapping subarrays
         */

        //  The index of the jth element is j - 1
        //  localMax[i][j] = max(localMax[i][j - 1], globalMax[i - 1][j - 1]) + num[j - 1];

        //  if (i == j) {
        //      globalMax[i][j] = localMax[i][j];
        //  } else {
        //      globalMax[i][j] = max(globalMax[i][j - 1], localMax[i][j]);
        //  }
        public int maxSubArray(int[] nums, int k) {
            // write your code here
            if (nums == null || nums.length < k) {
                return -1;
            }

            int len = nums.length;
            int[][] localMax = new int[k + 1][len + 1];
            int[][] globalMax = new int[k + 1][len + 1];

            for (int i = 1; i <= k; i++) {
                //小于 i 的数组不能够partition
                localMax[i][i - 1] = Integer.MIN_VALUE;
                for (int j = i; j <= len; j++) {
                    localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1]) + nums[j - 1];

                    if (i == j) {
                        globalMax[i][j] = localMax[i][j];
                    } else {
                        globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
                    }
                }
            }

            return globalMax[k][len];
        }
    }
}
