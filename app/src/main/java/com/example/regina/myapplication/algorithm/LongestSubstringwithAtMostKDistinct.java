package com.example.regina.myapplication.algorithm;


//386. Longest Substring with At Most K Distinct Characters
//        中文English
//        Given a string S, find the length of the longest substring T that contains at most k distinct characters.
//
//        Example
//        Example 1:
//
//        Input: S = "eceba" and k = 3
//        Output: 4
//        Explanation: T = "eceb"
//        Example 2:
//
//        Input: S = "WORLD" and k = 4
//        Output: 4
//        Explanation: T = "WORL" or "ORLD"
//        Challenge
//        O(n) time


public class LongestSubstringwithAtMostKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (k <= 0) {
            return 0;
        }

        if (s == null || s.length() < k) {
            return s.length();
        }

        int[] count = new int[256];
        int right = 0;
        int ans = -1;
        int uniqueCount = 0;

        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && uniqueCount <= k) {
                count[s.charAt(right)]++;
                if (count[s.charAt(right)] == 1) {
                    uniqueCount++;
                }
                right++;

                if (uniqueCount <= k && ans < right - left) {
                    ans = right - left;
                }
            }

            if (uniqueCount <= k && ans < right - left) {
                ans = right - left;
            }
            count[s.charAt(left)]--;
            if (count[s.charAt(left)] == 0) {
                uniqueCount--;
            }
        }

        return ans == -1 ? s.length() : ans;
    }
}
