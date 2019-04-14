package com.example.regina.myapplication.algorithm;


//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//        For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//        Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
//
//        Note
//
//        You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                p1 = i;

            }
            if(words[i].equals(word2)){
                p2 = i;
            }

            if(p1 != -1 && p2 != -1) minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }
        return minDistance;
    }
}



//    Shortest Word Distance II
//    This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
//
//        Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
//
//        For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//        Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = “makes”, word2 = “coding”, return 1.
//
//        Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

class WordDistanceII {

    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public WordDistanceII(String[] words) {

        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            if (map.containsKey(curWord)) {
                map.get(curWord).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(curWord, list);
            }

        }
    }

    public int shortestDistance(String word1, String word2) {
        List<Integer> indexList1 = map.get(word1);
        List<Integer> indexList2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;

        while (p1 < indexList1.size() && p2 < indexList2.size()) {
            int idx1 = indexList1.get(p1);
            int idx2 = indexList2.get(p2);
            minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            if (idx1 < idx2) p1++;
            else p2++;
        }

        return minDistance;
    }
}


//    Shortest Word Distance III
//    This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
//        Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//        word1 and word2 may be the same and they represent two individual words in the list.
//
//        For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//        Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = “makes”, word2 = “makes”, return 3.
//
//        Note: You may assume word1 and word2 are both in the list.



class WordDistanceIII {

    int shortestWordDistance(String[] words, String word1, String word2) {

        int p1 = -1, p2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i=0; i < words.length; ++i){
            String curWord = words[i];
            if(word1.equals(word2)){
                if(curWord.equals(word1)){
                    // let p1, p2 point to the two largest indexes
                    if(p2 < p1) p2 = i;
                    else p1 = i;
                }
            }else{
                if(curWord.equals(word1)) p1 = i;
                if(curWord.equals(word2)) p2 = i;
            }
            if(p1 >= 0 && p2 >= 0)
                minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }
        return minDistance;
    }
};
