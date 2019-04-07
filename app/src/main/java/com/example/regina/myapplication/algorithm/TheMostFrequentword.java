package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//1484. The Most Frequent word
//        中文English
//        Give a string s which represents the content of the novel, and then give a list indicating that the words do not participate in statistics, find the most ;frequent word(return the one with the smallest lexicographic order if there are more than one word)
//
//        Example
//        Input: s = "Jimmy has an apple, it is on the table, he like it"
//        excludeWords = ["a","an","the"]
//        Output:"it"

public class TheMostFrequentword {

    public class Solution {
        /**
         * @param s:            a string
         * @param excludewords: a dict
         *
         * @return: the most frequent word
         */
        public String frequentWord(String s, Set<String> excludewords) {
            // Write your code here
            if (s == null || excludewords == null) {
                return null;
            }

            s += ".";
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            int mostFre = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append(c);
                    continue;
                }

                if (sb.length() > 0) {
                    String word = sb.toString();
                    if (!excludewords.contains(word)) {
                        if (!map.containsKey(word)) {
                            map.put(word, 1);
                        } else {
                            map.put(word, map.get(word) + 1);
                        }
                        if (map.get(word) > mostFre) {
                            mostFre = map.get(word);
                            set.clear();
                            set.add(word);
                        } else if (map.get(word) == mostFre) {
                            set.add(word);
                        }
                    }
                }

                sb = new StringBuilder();
            }

            List<String> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<String>() {
                public int compare(String a, String b) {
                    return a.compareTo(b);
                }
            });

            return list.size() > 0 ? list.get(0) : null;
        }
    }
}
