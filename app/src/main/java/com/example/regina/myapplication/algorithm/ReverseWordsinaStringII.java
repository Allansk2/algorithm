package com.example.regina.myapplication.algorithm;



//927. Reverse Words in a String II
//        中文English
//        Given an input character array, reverse the array word by word. A word is defined as a sequence of non-space characters.
//
//        The input character array does not contain leading or trailing spaces and the words are always separated by a single space.
//
//        Example
//        Example1
//
//        Input: s = "the sky is blue"
//        Output: "blue is sky the"
//        Example2
//
//        Input: "a b c"
//        Output: "c b a"
//        Challenge
//        Could you do it in-place without allocating extra space?

public class ReverseWordsinaStringII {

    public class Solution {
        /**
         * @param str: a string
         * @return: return a string
         */
        public void Swap(char[] str, int l, int r) {
            for (int i = l; i <= (l + r) / 2; ++i) {
                char tmp = str[i];
                str[i] = str[l + r - i];
                str[l + r - i] = tmp;
            }
        }
        public char[] reverseWords(char[] str) {
            // write your code here
            int n = str.length, pre = 0;
            for (int i = 0; i <= n; ++i) {
                if (i == n || str[i] == ' ') {
                    Swap(str, pre, i - 1);
                    pre = i + 1;
                }
            }
            Swap(str, 0, n - 1);
            return str;
        }
    }


}
