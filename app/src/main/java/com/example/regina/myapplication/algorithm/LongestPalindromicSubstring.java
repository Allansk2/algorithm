package com.example.regina.myapplication.algorithm;


//200. Longest Palindromic Substring
//        中文English
//        Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
//
//        Example
//        Example 1:
//
//        Input:"abcdzdcab"
//        Output:"cdzdc"
//        Example 2:
//
//        Input:"aba"
//        Output:"aba"
//        Challenge
//        O(n2) time is acceptable. Can you do it in O(n) time.


public class LongestPalindromicSubstring {
    public class Solution {
        /**
         * @param s: input string
         * @return: the longest palindromic substring
         */
        public String longestPalindrome(String s) {
            // write your code here
            if (s == null) {
                return null;
            }

            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                String substring1 = findPal(s, i, i);
                String substring2 = findPal(s, i, i + 1);
                if (ans.length() < substring1.length()) {
                    ans = substring1;
                }
                if (ans.length() < substring2.length()) {
                    ans = substring2;
                }
            }

            return ans;
        }

        private String findPal(String s, int left, int right) {
            String ans = "";
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans = s.substring(left, right + 1);
                left--;
                right++;
            }

            return ans;
        }
    }
}
