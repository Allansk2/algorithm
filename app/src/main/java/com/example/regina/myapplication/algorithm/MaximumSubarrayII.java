package com.example.regina.myapplication.algorithm;

//42. Maximum Subarray II
//        中文English
//        Given an array of integers, find two non-overlapping subarrays which have the largest sum.
//        The number in each subarray should be contiguous.
//        Return the largest sum.
//
//        Example
//        Example 1:
//
//        Input:
//        [1, 3, -1, 2, -1, 2]
//        Output:
//        7
//        Explanation:
//        the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2].
//        Example 2:
//
//        Input:
//        [5,4]
//        Output:
//        9
//        Explanation:
//        the two subarrays are [5] and [4].
//        Challenge
//        Can you do it in time complexity O(n) ?
//
//        Notice
//        The subarray should contain at least one number
//
//这个题的思路是，因为 两个subarray 一定不重叠
//
//        所以必定存在一条分割线
//
//        分开这两个 subarrays
//
//        所以 最后的部分里：
//
//        max = Integer.MIN_VALUE;
//
//        for(int i = 0; i < size - 1; i++){
//
//        max = Math.max(max, left[i] + right[i + 1]);
//
//        }
//
//        return max;
//
//        这里是在枚举 这条分割线的位置
//
//        然后 left[] 和 right[] 里分别存的是，某个位置往左的 maximum subarray 和往右的 maximum subarray

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarrayII {

//    public class Solution {
//        /**
//         * @param nums: A list of integers
//         *
//         * @return: An integer denotes the sum of max two non-overlapping subarrays
//         */
//        public int maxTwoSubArrays(ArrayList<Integer> nums) {
//            // write your code
//            int size = nums.size();
//            int[] left = new int[size];
//            int[] right = new int[size];
//            int sum = 0;
//            int minSum = 0;
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < size; i++) {
//                sum += nums.get(i);
//                max = Math.max(max, sum - minSum);
//                minSum = Math.min(sum, minSum);
//                left[i] = max;
//            }
//            sum = 0;
//            minSum = 0;
//            max = Integer.MIN_VALUE;
//            for (int i = size - 1; i >= 0; i--) {
//                sum += nums.get(i);
//                max = Math.max(max, sum - minSum);
//                minSum = Math.min(sum, minSum);
//                right[i] = max;
//            }
//            max = Integer.MIN_VALUE;
//            for (int i = 0; i < size - 1; i++) {
//                max = Math.max(max, left[i] + right[i + 1]);
//            }
//            return max;
//        }
//    }




    public class Solution {
        /*
         * @param nums: A list of integers
         * @return: An integer denotes the sum of max two non-overlapping subarrays
         */
        public int maxTwoSubArrays(List<Integer> nums) {
            // write your code here

            return maxSubArray(nums, 2);
        }

        public int maxSubArray(List<Integer> nums, int k) {
            // write your code here
            if (nums == null || nums.size() < k) {
                return -1;
            }

            int len = nums.size();
            int[][] localMax = new int[k + 1][len + 1];
            int[][] globalMax = new int[k + 1][len + 1];

            for (int i = 1; i <= k; i++) {
                //小于 i 的数组不能够partition
                localMax[i][i - 1] = Integer.MIN_VALUE;
                for (int j = i; j <= len; j++) {
                    localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1]) + nums.get(j - 1);

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
