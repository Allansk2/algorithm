package com.example.regina.myapplication.algorithm;

//题目描述
//        完成一个函数，读入一个字符串，把其中的元音字母反转，返回反转后的字符串。
//
//        Example 1:
//        s = "hello", 返回 "holle".
//        Example 2:
//        s = "leetcode", 返回 "leotcede".




//1282. Reverse Vowels of a String
//        中文English
//        Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example
//        Example 1:
//
//        Input : s = "hello"
//        Output :  "holle"
//        Example 2:
//
//        Input : s = "lintcode"
//        Output : "lentcodi".
//        Notice
//        The vowels does not include the letter "y".


import java.util.HashSet;
import java.util.Set;

public class ReverseYuan {

    public class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            int[] pos = new int[s.length()];
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');

            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    pos[index] = i;
                    index++;
                }
            }

            char[] ans = s.toCharArray();
            for (int i = 0; i < index; i++) {
                ans[pos[i]] = s.charAt(pos[index - i - 1]);
            }

            return String.valueOf(ans);
        }
    }

}
