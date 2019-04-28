package com.example.regina.myapplication.algorithm;

//135. Combination Sum
//        中文English
//        Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//        The same repeated number may be chosen from C unlimited number of times.
//
//        Example
//        Given candidate set [2,3,6,7] and target 7, a solution set is:
//
//        [7]
//        [2, 2, 3]
//        Notice
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        Arrays.sort(candidates);
        helper(candidates, ans, new ArrayList<Integer>(), target, 0);

        return ans;
    }

    private void helper(int[] candidates, List<List<Integer>> ans, List<Integer> subset, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(subset));
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            subset.add(candidates[i]);
            helper(candidates, ans, subset, target - candidates[i], i);
            subset.remove(subset.size() - 1);
        }
    }
}
