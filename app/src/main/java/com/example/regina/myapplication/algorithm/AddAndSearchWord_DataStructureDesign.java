package com.example.regina.myapplication.algorithm;

//473. Add and Search Word - Data structure design
//        中文English
//        Design a data structure that supports the following two operations: addWord(word) and search(word)
//
//        search(word) can search a literal word or a regular expression string containing only letters a-z or ..
//
//        A . means it can represent any one letter.
//
//        Example
//        Example 1:
//
//        Input:
//        addWord("a")
//        search(".")
//        Output:
//        true
//        Example 2:
//
//        Input:
//        addWord("bad")
//        addWord("dad")
//        addWord("mad")
//        search("pad")
//        search("bad")
//        search(".ad")
//        search("b..")
//        Output:
//        false
//        true
//        true
//        true
//        Notice
//        You may assume that all words are consist of lowercase letters a-z.

public class AddAndSearchWord_DataStructureDesign {
    public class WordDictionary {
        class TrieNode {
            TrieNode[] nodes = new TrieNode[26];
            boolean isEnd = false;
        }

        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode current = root;
            if (word != null && word.length() > 0) {
                for (char c : word.toCharArray()) {
                    int pos = c - 'a';
                    if (current.nodes[pos] == null) {
                        current.nodes[pos] = new TrieNode();
                    }
                    current = current.nodes[pos];
                }
                current.isEnd = true;
            }
        }

        /*
         * @param word: A word could contain the dot character '.' to represent any one letter.
         * @return: if the word is in the data structure.
         */
        public boolean search(String word) {
//            return search(word, root);
            return find(word, 0, root);
        }

        public boolean search(String word, TrieNode current) {
            if (word != null && word.length() > 0) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (c == '.') {
                        for (int j = 0; j < 26; j++) {
                            String newWord = (char) ('a' + j) + word.substring(i + 1);
                            if (search(newWord, current)) {
                                return true;
                            }
                        }
                        return false;
                    } else {
                        int pos = c - 'a';
                        if (current.nodes[pos] == null) {
                            return false;
                        }
                        current = current.nodes[pos];
                    }
                }
                return current.isEnd;
            }
            return true;
        }

        // DFS
        boolean find(String word, int index, TrieNode current) {
            if (index >= word.length()) {
                return current.isEnd;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (current.nodes[i] == null) {
                        continue;
                    }
                    if (find(word, index + 1, current.nodes[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int pos = c - 'a';
                if (current.nodes[pos] == null) {
                    return false;
                }

                return find(word, index + 1, current.nodes[pos]);
            }
        }
    }
}
