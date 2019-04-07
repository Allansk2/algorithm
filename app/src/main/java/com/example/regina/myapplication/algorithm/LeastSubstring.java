package com.example.regina.myapplication.algorithm;


//1638. Least Substring
//        中文English
//        Given a string containing n lowercase letters, the string needs to be divided into several continuous substrings, the letter in the substring should be same, and the number of letters in the substring does not exceed k, and output the minimal substring number meeting the requirement.
//
//        Example
//        Example1
//
//        Input: s = "aabbbc", k = 2
//        Output: 4
//        Explanation:
//        we can get "aa", "bb", "b", "c" four substring.
//        Example2
//
//        input: s = "aabbbc", k = 3
//        Output: 3
//        we can get "aa", "bbb", "c" three substring.
//        Notice
//        n \leq 1e5n≤1e5

public class LeastSubstring {

    public class Solution {
        /**
         * @param s: the string s
         * @param k: the maximum length of substring
         * @return: return the least number of substring
         */
        public int getAns(String s, int k) {
            // Write your code here
            if (s == null) {
                return -1;
            }

            int n = s.length(), ans = 1, cur = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1) && cur < k) {
                    cur++;
                } else {
                    ans++;
                    cur = 1;
                }
            }

            return ans;
        }
    }
}
