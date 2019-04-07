package com.example.regina.myapplication.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//1369. Most Common Word
//        中文English
//        Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words. It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
//
//        Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case sensitive. The answer is in lowercase.
//
//        Example
//        Example1
//
//        Input:  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." and banned = ["hit"]
//        Output: "ball"
//        Explanation:
//        "hit" occurs 3 times, but it is a banned word.
//        "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
//        Note that words in the paragraph are not case sensitive,
//        that punctuation is ignored (even if adjacent to words, such as "ball,"),
//        and that "hit" isn't the answer even though it occurs more because it is banned.
//        Example2
//
//        Input:  paragraph = "a a a b b c c d" and banned = ["a","b"]
//        Output: "c"
//        Explanation:
//        "a" and "b" are banned words
//        "c" occurs 2 times and "d" occurs only once
//        So output "c"
//        Notice
//        1 <= paragraph.length <= 1000.
//        1 <= banned.length <= 100.
//        1 <= banned[i].length <= 10.
//        The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
//        paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
//        Different words in paragraph are always separated by a space.
//        There are no hyphens or hyphenated words.
//        Words only consist of letters, never apostrophes or other punctuation symbols.



public class MostCommonWord {
    public class Solution {
        /**
         * @param paragraph:
         * @param banned:
         * @return: nothing
         */
        public String mostCommonWord (String paragraph, String[] banned) {
            Set<String> ban = new HashSet<>(Arrays.asList (banned));
            Map<String, Integer> count = new HashMap<>();
            String[] words = paragraph.replaceAll ("\\pP", " ").toLowerCase().split ("\\s+");
            for (String w : words) if (!ban.contains (w)) count.put (w, count.getOrDefault (w, 0) + 1);
//            return Collections.max (count.entrySet(), Map.Entry.comparingByValue()).getKey();

            return "";
        }
    }

}
