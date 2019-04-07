package com.example.regina.myapplication.algorithm;

import java.util.Set;

/**
 * Created by Allan Zhu on 2019-03-22.
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
            // write your code here
            if (s == null || s.length() == 0) {
                return true;
            }

            boolean[] hasSegment = new boolean[s.length() + 1];
            hasSegment[0] = true;
            for (int i = 0; i < s.length(); i++) {
                if (!hasSegment[i]) {
                    continue;
                }

                for (int j = i + 1; j <= s.length(); j++) {
                    if (hasSegment[j]) {
                        continue;
                    }
                    String sub = s.substring(i, j);
                    if (dict.contains(sub)) {
                        hasSegment[j] = true;
                    }
                }
            }

            return hasSegment[s.length()];
        }
    }
}
