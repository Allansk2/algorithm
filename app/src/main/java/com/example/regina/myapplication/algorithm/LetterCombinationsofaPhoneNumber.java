package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.List;


//425. Letter Combinations of a Phone Number
//        中文English
//        Given a digit string excluded '0' and '1', return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//        1	2
//        ABC	3
//        DEF
//        4
//        GHI	5
//        JKL	6
//        MNO
//        7
//        PQRS	8
//        TUV	9
//        WXYZ
//        Example
//        Example 1:
//
//        Input: "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//        Explanation:
//        '2' could be 'a', 'b' or 'c'
//        '3' could be 'd', 'e' or 'f'
//        Example 2:
//
//        Input: "5"
//        Output: ["j", "k", "l"]
//        Notice
//        Although the answer above is in lexicographical order, your answer could be in any order you want.


public class LetterCombinationsofaPhoneNumber {

    public class Solution {
        /**
         * @param digits: A digital string
         * @return: all posible letter combinations
         */
        public List<String> letterCombinations(String digits) {
            String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            List<String> ans = new ArrayList<>();
            if (digits.length() == 0) {
                return ans;
            }

            dfs(0, digits.length(), "", digits, phone, ans);
            return ans;
        }

        private void dfs(int x, int l, String str, String digits, String phone[], List<String> ans) {
            if (x == l) {
                ans.add(str);
                return;
            }
            int d = digits.charAt(x) - '0';
            for (char c : phone[d].toCharArray()) {
                dfs(x + 1, l, str + c, digits, phone, ans);
            }
        }
    }

}
