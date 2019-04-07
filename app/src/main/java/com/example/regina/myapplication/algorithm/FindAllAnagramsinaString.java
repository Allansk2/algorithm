package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allan Zhu on 2019-03-23.
 */
public class FindAllAnagramsinaString {

    public class Solution {
        /**
         * @param s: a string
         * @param p: a string
         * @return: a list of index
         */
        public List<Integer> findAnagrams(String s, String p) {
            // write your code here
            List<Integer> ans = new ArrayList<>();
            if (s == null || p == null || s.length() < p.length()) {
                return ans;
            }

            int[] charCountP = new int[26];
            for (char aChar: p.toCharArray()) {
                charCountP[aChar - 'a']++;
            }

            int[] charCountS = new int[26];

            int N = p.length();
            for (int i = 0; i < N; i++) {
                charCountS[s.charAt(i) - 'a']++;
            }
            if (isAnagram(charCountP, charCountS)) {
                ans.add(0);
            }

            int start = 1;
            for (; start <= s.length() - p.length(); start++) {
                charCountS[s.charAt(start -1) - 'a']--;
                charCountS[s.charAt(start + N - 1) - 'a']++;
                if (isAnagram(charCountP, charCountS)) {
                    ans.add(start);
                }
            }

            return ans;
        }

        private boolean isAnagram(int[] char1, int[] char2) {
            for (int i = 0; i < 26; i++) {
                if (char1[i] != char2[i]) {
                    return false;
                }
            }

            return true;
        }
    }

}
