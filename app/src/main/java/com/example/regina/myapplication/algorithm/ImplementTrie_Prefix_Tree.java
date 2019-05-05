package com.example.regina.myapplication.algorithm;

//442. Implement Trie (Prefix Tree)
//        中文English
//        Implement a Trie with insert, search, and startsWith methods.
//
//        Example
//        Example 1:
//
//        Input:
//        insert("lintcode")
//        search("lint")
//        startsWith("lint")
//        Output:
//        false
//        true
//        Example 2:
//
//        Input:
//        insert("lintcode")
//        search("code")
//        startsWith("lint")
//        startsWith("linterror")
//        insert("linterror")
//        search("lintcode)
//        startsWith("linterror")
//        Output:
//        false
//        true
//        false
//        true
//        true
//        Notice
//        You may assume that all inputs are consist of lowercase letters a-z.

public class ImplementTrie_Prefix_Tree {
    public class Trie {
        class TrieNode {
            TrieNode[] nodes = new TrieNode[26];
            boolean isEnd = false;
        }

        TrieNode root = new TrieNode();

        public Trie() {
            // do intialization if necessary
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
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
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode current = root;
            if (word != null && word.length() > 0) {
                for (char c : word.toCharArray()) {
                    int pos = c - 'a';
                    if (current.nodes[pos] == null) {
                        return false;
                    }
                    current = current.nodes[pos];
                }
                return current.isEnd;
            }
            return true;
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            if (prefix != null && prefix.length() > 0) {
                for (char c : prefix.toCharArray()) {
                    int pos = c - 'a';
                    if (current.nodes[pos] == null) {
                        return false;
                    }
                    current = current.nodes[pos];
                }
                return true;
            }
            return true;
        }
    }
}
