package com.example.regina.myapplication.algorithm;

//627. Longest Palindrome
//        中文English
//        Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//        This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//        Example
//        Example 1:
//
//        Input : s = "abccccdd"
//        Output : 7
//        Explanation :
//        One longest palindrome that can be built is "dccaccd", whose length is `7`.
//        Notice
//        Assume the length of given string will not exceed 1010.

public class LongestPalindrome {

    public class Solution {
        /**
         * @param s: a string which consists of lowercase or uppercase letters
         * @return: the length of the longest palindromes that can be built
         */
        public int longestPalindrome(String s) {
            // write your code here
            if (s == null || s.length() == 0) {
                return 0;
            }

            int[] charCount = new int[52];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = 0;
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    index = chars[i] - 'a';
                } else {
                    index = chars[i] - 'A' + 26;
                }
                charCount[index]++;
            }

            int count = 0;
            boolean hasAddSingle = false;
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] % 2 == 0) {
                    count += charCount[i];
                } else {
                    if (!hasAddSingle) {
                        hasAddSingle = true;
                        count += charCount[i];
                    } else {
                        count += charCount[i] / 2 * 2;
                    }
                }
            }

            return count;
        }
    }

}
