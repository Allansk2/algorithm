package com.example.regina.myapplication.algorithm;

import java.util.Stack;


//423. Valid Parentheses
//        中文English
//        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//
//        Example
//        Example 1:
//
//        Input: "([)]"
//        Output: False
//        Example 2:
//
//        Input: "()[]{}"
//        Output: True
//        Challenge
//        Use O(n) time, n is the number of parentheses.

public class ValidParentheses {
    public class Solution {
        /**
         * @param s A string
         * @return whether the string is a valid parentheses
         */
        public boolean isValidParentheses(String s) {
            // Write your code here
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

}
