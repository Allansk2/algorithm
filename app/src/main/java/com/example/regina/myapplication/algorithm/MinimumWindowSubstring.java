package com.example.regina.myapplication.algorithm;


//32. Minimum Window Substring
//        中文English
//        Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
//
//        Example
//        Example 1:
//
//        Input:
//        ""
//        ""
//        Output:
//        ""
//        Example 2:
//
//        Input:
//        "ADOBECODEBANC"
//        "ABC"
//        Output:
//        "BANC"
//        Challenge
//        Can you do it in time complexity O(n) ?
//
//        Clarification
//        Should the characters in minimum window has the same order in target?
//
//        Not necessary.
//        Notice
//        If there is no such window in source that covers all characters in target, return the emtpy string "".
//        If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
//        The target string may contain duplicate characters, the minimum window should cover all characters including the duplicate characters in target.


public class MinimumWindowSubstring {
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || target == null || source.length() < target.length()) {
            return "";
        }

        if (source.equals(target)) {
            return target;
        }

        int[] count = new int[256];
        for (int i = 0; i < target.length(); i++) {
            count[source.charAt(i)]++;
            count[target.charAt(i)]--;
        }

        int countNegative = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] < 0) {
                countNegative++;
            }
        }

        int right = target.length();
        String ans = null;

        for (int left = 0; left <= source.length() - target.length(); left++) {
            while (right < source.length() && countNegative > 0) {
                if (count[source.charAt(right)] == -1) {
                    countNegative--;
                }

                count[source.charAt(right)]++;
                right++;
            }

            if (countNegative == 0) {
                if (ans == null || ans.length() > right - left) {
                    ans = source.substring(left, right);
                }
            }

            if (count[source.charAt(left)] == 0) {
                countNegative++;
            }
            count[source.charAt(left)]--;
        }

        return ans == null ? "" : ans;
    }

}
