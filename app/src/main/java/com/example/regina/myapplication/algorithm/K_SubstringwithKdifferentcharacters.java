package com.example.regina.myapplication.algorithm;


//1639. K-Substring with K different characters
//        中文English
//        Given a string S and an integer K.
//        Calculate the number of substrings of length K and containing K different characters
//
//        Example
//        String: "abcabc"
//        K: 3
//
//        Answer: 3
//        substrings:  ["abc", "bca", "cab"]
//        String: "abacab"
//        K: 3
//
//        Answer: 2
//        substrings: ["bac", "cab"]

import java.util.HashSet;
import java.util.Set;

public class K_SubstringwithKdifferentcharacters {

    public class Solution {
        /**
         * @param stringIn: The original string.
         * @param K: The length of substrings.
         * @return: return the count of substring of length K and exactly K distinct characters.
         */
        public int KSubstring(String stringIn, int K) {
            // Write your code here
            Set<String> set = new HashSet<>();
            if (stringIn == null || stringIn.length() < K) {
                return 0;
            }

            int[] charCount = new int[256];
            boolean shouldAdd = true;
            for (int i = 0; i < K; i++) {
                int index = stringIn.charAt(i);
                charCount[index]++;
                if (charCount[index] > 1) {
                    shouldAdd = false;
                }
            }

            if (shouldAdd) {
                set.add(stringIn.substring(0, K));
            }

            for (int i = 1; i <= stringIn.length() - K; i++) {
                charCount[stringIn.charAt(i + K - 1)]++;
                charCount[stringIn.charAt(i - 1)]--;
                if (isUnique(charCount)) {
                    set.add(stringIn.substring(i, i + K));
                }
            }

            return set.size();
        }

        private boolean isUnique(int[] charCount) {
            for (int i = 0; i < 256; i++) {
                if (charCount[i] > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
