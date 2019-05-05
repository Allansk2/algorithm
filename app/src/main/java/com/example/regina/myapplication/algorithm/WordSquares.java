package com.example.regina.myapplication.algorithm;

//634. Word Squares
//        中文English
//        Given a set of words without duplicates, find all word squares you can build from them.
//
//        A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
//
//        For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
//
//        b a l l
//        a r e a
//        l e a d
//        l a d y
//        Example
//        Example 1:
//
//        Input:
//        ["area","lead","wall","lady","ball"]
//        Output:
//        [["wall","area","lead","lady"],["ball","area","lead","lady"]]
//
//        Explanation:
//        The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//        Example 2:
//
//        Input:
//        ["abat","baba","atan","atal"]
//        Output:
//        [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
//        Notice
//        There are at least 1 and at most 1000 words.
//        All words will have the exact same length.
//        Word length is at least 1 and at most 5.
//        Each word contains only lowercase English alphabet a-z.

import java.util.ArrayList;
import java.util.List;

public class WordSquares {

    class TrieNode {
        TrieNode[] nodes = null;
        List<String> startWith = null;

        public TrieNode() {
            nodes = new TrieNode[26];
            startWith = new ArrayList<>();
        }
    }

    class TrieTree {
        TrieNode root = null;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            if (word != null && word.length() > 0) {
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (current.nodes[index] == null) {
                        current.nodes[index] = new TrieNode();
                    }

                    current.startWith.add(word);
                    current = current.nodes[index];
                }
            }
        }

        public List<String> findPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode current = root;
            if (prefix != null && prefix.length() > 0) {
                for (char c : prefix.toCharArray()) {
                    int index = c - 'a';
                    if (current.nodes[index] == null) {
                        return ans;
                    }
                    current = current.nodes[index];
                }
                ans.addAll(current.startWith);
            }
            return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }

        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.insert(word);
        }

        final ArrayList<String> subset = new ArrayList<>();
        for (String word : words) {
            subset.add(word);
            dfs(word.length(), tree, ans, subset);
            subset.remove(subset.size() - 1);
        }

        return ans;
    }

    private void dfs(int len, TrieTree tree, List<List<String>> ans, List<String> subset) {
        if (subset.size() == len) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        String prefix = "";
        int row = subset.size();
        for (int i = 0; i < subset.size(); i++) {
            prefix += subset.get(i).charAt(row);
        }

        final List<String> words = tree.findPrefix(prefix);
        for (String word : words) {
            subset.add(word);
            dfs(len, tree, ans, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
