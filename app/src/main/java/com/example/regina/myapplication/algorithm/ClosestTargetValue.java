package com.example.regina.myapplication.algorithm;


//1478. Closest Target Value
//        中文English
//        Given an array, find two numbers in the array and their sum is closest to the target value but does not exceed the target value, return their sum.
//
//        Example
//        Example1
//
//        Input: target = 15 and array = [1,3,5,11,7]
//        Output: 14
//        Explanation:
//        11+3=14
//        Example2
//
//        Input: target = 16 and array = [1,3,5,11,7]
//        Output: 16
//        Explanation:
//        11+5=16
//        Notice
//        if there is no result meet the requirement, return -1.

import java.util.Arrays;

public class ClosestTargetValue {
    public int closestTargetValue (int target, int[] array) {
        // Write your code here
        int n = array.length;
        if (n < 2) {
            return -1;
        }
        Arrays.sort (array);
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (array[left] + array[right] > target) {
                right--;
            } else {
                diff = Math.min (diff, target - (array[left] + array[right]));
                left++;
            }
        }
        if (diff == Integer.MAX_VALUE) {
            return -1;
        } else {
            return target - diff;
        }
    }

}
