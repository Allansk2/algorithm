package com.example.regina.myapplication.algorithm;


//213. String Compression
//        中文English
//        Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
//
//        If the "compressed" string would not become smaller than the original string, your method should return the original string.
//
//        You can assume the string has only upper and lower case letters (a-z).
//
//        Example
//        Example 1:
//
//        Input: str = "aabcccccaaa"
//        Output: "a2b1c5a3"
//        Example 2:
//
//        Input: str = "aabbcc"
//        Output: "aabbcc"

public class StringCompression {

    public class Solution {
        /**
         * @param originalString: a string
         * @return: a compressed string
         */
        public String compress(String originalString) {
            // write your code here
            if (originalString == null || originalString.length() == 0) {
                return originalString;
            }

            int length = findCount(originalString);
            if (length >= originalString.length()) {
                return originalString;
            }
            char[] chars = new char[length];
            char last = originalString.charAt(0);
            int count = 1, index = 0;
            for (int i = 1; i < originalString.length(); i++) {
                if (originalString.charAt(i) == last) {
                    count++;
                } else {
                    index = setChar(chars, last, index, count);

                    last = originalString.charAt(i);
                    count = 1;
                }
            }

            index = setChar(chars, last, index, count);

            return String.valueOf(chars);
        }

        private int setChar(char[] chars, char last, int index, int count) {
            chars[index] = last;
            index++;
            char[] nums = String.valueOf(count).toCharArray();
            for (char c: nums) {
                chars[index] = c;
                index++;
            }
            return index;
        }

        private int findCount(String str) {
            char[] chars = str.toCharArray();
            char last = chars[0];
            int size = 0, count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == last) {
                    count++;
                } else {
                    last = chars[i];
                    size += 1 + String.valueOf(count).length();
                    count = 1;
                }
            }

            size += 1 + String.valueOf(count).length();

            return size;
        }
    }
}
