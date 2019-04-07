package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//120. Word Ladder
//        中文English
//        Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//        Only one letter can be changed at a time
//        Each intermediate word must exist in the dictionary
//        Example
//        Given:
//        start = "hit"
//        end = "cog"
//        dict = ["hot","dot","dog","lot","log"]
//        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//
//        Notice
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.



public class WordLadder {

    public class Solution {
        /*
         * @param start: a string
         * @param end: a string
         * @param dict: a set of string
         * @return: An integer
         */
        public int ladderLength(String start, String end, Set<String> dict) {
            // write your code here
            if (start == null || end == null) {
                return 0;
            }
            if (start.equals(end)) {
                return 1;
            }

            dict.add(end);
            Set<String> checkWord = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);
            checkWord.add(start);

            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    List<String> next = generateNext(word, dict);
                    for (String newWord: next) {
                        if (newWord.equals(end)) {
                            return ++step;
                        }
                        if (!checkWord.contains(newWord)) {
                            queue.offer(newWord);
                            checkWord.add(newWord);
                        }
                    }
                }
                step++;
            }

            return 0;
        }

        private List<String> generateNext(String word, Set<String> dict) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (word.charAt(i) == c) {
                        continue;
                    }
                    char[] chars = word.toCharArray();
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (dict.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }

            return result;
        }
    }
}
