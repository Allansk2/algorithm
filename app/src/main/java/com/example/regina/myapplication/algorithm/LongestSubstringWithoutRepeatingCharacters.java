package com.example.regina.myapplication.algorithm;

//384. Longest Substring Without Repeating Characters
//        中文English
//        Given a string, find the length of the longest substring without repeating characters.
//
//        Example
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The longest substring is "abc".
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The longest substring is "b".
//        Challenge
//        time complexity O(n)


public class LongestSubstringWithoutRepeatingCharacters {
    public class Solution {
        /**
         * @param s: a string
         * @return: an integer
         */
        //方法一：
        public int lengthOfLongestSubstring(String s) {
            int[] map = new int[256]; // map from character's ASCII to its last occured index

            int j = 0;
            int i = 0;
            int ans = 0;
            for (i = 0; i < s.length(); i++) {
                while (j < s.length() && map[s.charAt(j)]==0) {
                    map[s.charAt(j)] = 1;
                    ans = Math.max(ans, j-i + 1);
                    j ++;
                }
                map[s.charAt(i)] = 0;
            }

            return ans;
        }
    }


}
