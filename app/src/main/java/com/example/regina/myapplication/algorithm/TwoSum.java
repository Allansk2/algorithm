package com.example.regina.myapplication.algorithm;

import java.util.HashMap;



//56. Two Sum
//        中文English
//        Given an array of integers, find two numbers such that they add up to a specific target number.
//
//        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
//
//        Example
//        Example1:
//        numbers=[2, 7, 11, 15], target=9
//        return [0, 1]
//        Example2:
//        numbers=[15, 2, 7, 11], target=9
//        return [1, 2]
//        Challenge
//        Either of the following solutions are acceptable:
//
//        O(n) Space, O(nlogn) Time
//        O(n) Space, O(n) Time
//        Notice
//        You may assume that each input would have exactly one solution

public class TwoSum {

    public class Solution {
        /*
         * @param numbers : An array of Integer
         * @param target : target = numbers[index1] + numbers[index2]
         * @return : [index1 + 1, index2 + 1] (index1 < index2)
             numbers=[2, 7, 11, 15],  target=9
             return [1, 2]
         */
        public int[] twoSum(int[] numbers, int target) {
            //用一个hashmap来记录，key记录target-numbers[i]的值，value记录numbers[i]的i的值，如果碰到一个
            //numbers[j]在hashmap中存在，那么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为答案
            HashMap<Integer,Integer> map = new HashMap<>();

            for (int i = 0; i < numbers.length; i++) {
                if (map.get(numbers[i]) != null) {
                    int[] result = {map.get(numbers[i]), i};
                    return result;
                }
                map.put(target - numbers[i], i);
            }

            int[] result = {};
            return result;
        }
    }


}
