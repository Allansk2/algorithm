package com.example.regina.myapplication.algorithm;

//132. Word Search II
//        中文English
//        Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
//
//        Example
//        Example 1:
//
//        Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
//        Output：["again","can","dad","dog"]
//        Explanation：
//        d o a f
//        a g a i
//        d c a n
//        search in Matrix，so return ["again","can","dad","dog"].
//        Example 2:
//
//        Input：["a"]，["b"]
//        Output：[]
//        Explanation：
//        a
//        search in Matrix，return [].
//        Challenge
//        Using trie to implement your algorithm.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
    class TrieNode {
        Map<Character, TrieNode> nodes = null;
        String word;

        public TrieNode() {
            nodes = new HashMap<>();
            word = null;
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
                    if (current.nodes.get(c) == null) {
                        current.nodes.put(c, new TrieNode());
                    }
                    current = current.nodes.get(c);
                }
                current.word = word;
            }
        }
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ans;
        }

        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, tree.root, ans);
            }
        }

        return ans;
    }

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    private void search(char[][] board, int x, int y, TrieNode current, List<String> ans) {
        if (!current.nodes.containsKey(board[x][y])) {
            return;
        }

        TrieNode next = current.nodes.get(board[x][y]);
        if (next.word != null) {
            if (!ans.contains(next.word)) {
                ans.add(next.word);
            }
        }

        if (next.nodes.size() == 0) {
            return;
        }

        char tmp = board[x][y];
        board[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] != 0) {
                search(board, newX, newY, next, ans);
            }
        }

        board[x][y] = tmp;
    }
}
