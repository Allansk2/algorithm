package com.example.regina.myapplication.algorithm;



//1377. Find Substring
//        中文English
//        Given the length k, find all substrings of length k in the string str.The characters of a substring can not be repeated and output the number of substrings that satisfy such conditions (the same substring is counted only 1 times).
//
//        Example
//        Example1
//
//        Input:  str = "abc", k = 2
//        Output: 2
//        Explanation:
//        Characters are not repeated, and substrings of length k have "ab", "bc".
//        Example2
//
//        Input: str = "abacb", k = 1
//        Output: 3
//        Explanation:
//        Characters are not repeated, and substrings of length k have "a", "b".”c”.
//        Notice
//        |str| <= 100000.
//        k <= 100000.
//        All characters are lowercase.

//用双指针可以将所有的满足条件的子串找出来，在去重方面可以采用字符串hash，也可以直接HashMap或者HashSet去重。

import java.util.HashSet;

public class FindSubstring {
    public int findSubstring(String str, int k) {
        // Write your code here
        if (k > 26) {
            return 0;
        }
        HashSet<String> stringSet = new HashSet<String>();
        int ans = 0;
        for (int i = 0; i + k - 1 < str.length(); i++) {
            HashSet<Character> hashSet = new HashSet<Character>();
            boolean isLegal = true;
            for (int j = i; j <= i + k - 1; j++) {
                if (hashSet.contains(str.charAt(j))) {
                    isLegal = false;
                    break;
                } else {
                    hashSet.add(str.charAt(j));
                }
            }
            if (isLegal) {
                String s = str.substring(i, i + k);
                if (stringSet.contains(s)) {
                    continue;
                } else {
                    stringSet.add(s);
                    ans++;
                }
            }
        }
        return ans;
    }
}
