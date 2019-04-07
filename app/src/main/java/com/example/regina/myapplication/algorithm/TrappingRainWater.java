package com.example.regina.myapplication.algorithm;



//363. Trapping Rain Water
//        中文English
//        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//        Trapping Rain Water
//
//        Example
//        Example 1:
//
//        Input: [0,1,0]
//        Output: 0
//        Example 2:
//
//        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6
//        Challenge
//        O(n) time and O(1) memory
//
//        O(n) time and O(n) memory is also acceptable.



public class TrappingRainWater {
    public class Solution {
        /**
         * @param heights: an array of integers
         * @return: a integer
         */
        public int trapRainWater(int[] heights) {
            // write your code here
            int left = 0, right = heights.length - 1;
            int res = 0;
            if(left >= right)
                return res;
            int leftheight = heights[left];
            int rightheight = heights[right];
            while(left < right) {
                if(leftheight < rightheight) {
                    left ++;
                    if(leftheight > heights[left]) {
                        res += (leftheight - heights[left]);
                    } else {
                        leftheight = heights[left];
                    }
                } else {
                    right --;
                    if(rightheight > heights[right]) {
                        res += (rightheight - heights[right]);
                    } else {
                        rightheight = heights[right];
                    }
                }
            }
            return res;
        }
    }
}
