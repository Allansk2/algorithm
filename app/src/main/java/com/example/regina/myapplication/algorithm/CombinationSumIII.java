package com.example.regina.myapplication.algorithm;

//216. Combination Sum III
//        Medium
//
//        549
//
//        29
//
//        Favorite
//
//        Share
//        Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//        Note:
//
//        All numbers will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Example 2:
//
//        Input: k = 3, n = 9
//        Output: [[1,2,6], [1,3,5], [2,3,4]]

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return ans;
        }

        helper(ans, new ArrayList<Integer>(), k, n, 1);

        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> subset, int k, int n, int index) {
        if (n == 0 && subset.size() == k) {
            ans.add(new ArrayList<Integer>(subset));
        }

        for (int i = index; i <= 9; i++) {
            if (subset.size() >= k) {
                break;
            }

            subset.add(i);
            helper(ans, subset, k, n - i, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
