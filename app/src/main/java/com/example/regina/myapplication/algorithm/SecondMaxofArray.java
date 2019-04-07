package com.example.regina.myapplication.algorithm;


//479. Second Max of Array
//        中文English
//        Find the second max number in a given array.
//
//        Example
//        Example1:
//
//        Input: [1, 3, 2, 4],
//        Output: 3.
//        Example2:
//
//        Input: [1, 2],
//        Output: 1.
//        Notice
//        You can assume the array contains at least two numbers.


public class SecondMaxofArray {
    public int secondMax(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }

        return second;
    }
}
