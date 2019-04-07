package com.example.regina.myapplication.algorithm;

//1481. Unique Substring
//        中文English
//        Given a string s, find all the unique substring with the length of k and sort the results in lexicographic order.
//
//        Example
//        Example 1:
//
//        Input: s = "caaab"，k = 2
//        Output:["aa","ab","ca"]
//        Explanation:
//        two adjacent lengths of strings are split and duplication removed
//        Example 2:
//
//        Input: s = "aaaa"，k = 3
//        Output:["aaa"]
//        Explanation:
//        three adjacent lengths of strings are split and duplication removed

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueSubstring {

    public List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        Set<String> ans = new TreeSet<String>();
        int len = s.length();
        for (int i = 0; i <= len - k; i++) {
            String sub = s.substring(i, i + k);
            ans.add(sub);
        }

        List<String> result = new ArrayList<>();
        for (String string : ans) {
            result.add(string);
        }

        return result;
    }
}
