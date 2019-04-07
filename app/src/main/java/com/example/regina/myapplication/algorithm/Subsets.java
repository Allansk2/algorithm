package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//17. Subsets
//        中文English
//        Given a set of distinct integers, return all possible subsets.
//
//        Example
//        Example 1:
//
//        Input: [0]
//        Output:
//        [
//        [],
//        [0]
//        ]
//        Example 2:
//
//        Input: [1,2,3]
//        Output:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
//        Challenge
//        Can you do it in both recursively and iteratively?
//
//        Notice
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.

public class Subsets {
    public class Solution {
        /**
         * @param nums: A set of numbers
         * @return: A list of lists
         */
        public List<List<Integer>> subsets(int[] nums) {
            // write your code here
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) {
                return result;
            }
            Arrays.sort(nums);
            DFS(nums, result, new ArrayList<Integer>(), 0);

            return result;
        }

        private void DFS(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
            result.add(new ArrayList(subset));
            if (start >= nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                DFS(nums, result, subset, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }

}
