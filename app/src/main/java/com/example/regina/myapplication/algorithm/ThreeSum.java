package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//57. 3Sum
//        中文English
//        Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Example
//        Example 1:
//
//        Input:[2,7,11,15]
//        Output:[]
//        Example 2:
//
//        Input:[-1,0,1,2,-1,-4]
//        Output:	[[-1, 0, 1],[-1, -1, 2]]
//        Notice
//        Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//
//        The solution set must not contain duplicate triplets.


public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                twoSum(nums, target, left, right, result);
            }

            return result;
        }

        private void twoSum(int[] nums, int target, int left, int right, List<List<Integer>> result) {
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> subset = new ArrayList<>();
                    subset.add(-target);
                    subset.add(nums[left]);
                    subset.add(nums[right]);
                    result.add(subset);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
