package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.SubtreewithMaximumAverage.TreeNode;

import java.util.HashSet;
import java.util.Set;


//1561. BST Node Distance
//        中文English
//        Given a list of numbers, construct a BST from it(you need to insert nodes one-by-one with the given order to get the BST) and find the distance between two given nodes.
//
//        Example
//        Example 1
//
//        Input:
//        numbers = [2,1,3]
//        node1 = 1
//        node2 = 3
//        Output:
//        2
//        Explaination:
//        The tree is look like this.
//        2
//        / \
//        1  3
//        Example 2
//
//        Input:
//        numbers = [2,1]
//        node1 = 1
//        node2 = 3
//        Output: -1
//        Notice
//        If two nodes do not appear in the BST, return -1
//        We guarantee that there are no duplicate nodes in BST
//        The node distance means the number of edges between two nodes


public class BSTNodeDistance {
    public class Solution {
        /**
         * @param numbers: the given list
         * @param node1: the given node1
         * @param node2: the given node2
         * @return: the distance between two nodes
         */

        private TreeNode insert(TreeNode root, int node) {
            if (root == null) {
                return new TreeNode(node);
            }
            if (root.val > node) {
                root.left = insert(root.left, node);
            } else if (root.val < node) {
                root.right = insert(root.right, node);
            }
            return root;
        }

        private TreeNode buildTree(int[] numbers) {
            TreeNode root = new TreeNode(numbers[0]);
            int len = numbers.length;
            for (int i = 1; i < len; ++i) {
                insert(root, numbers[i]);
            }
            return root;
        }

        private int findDis(TreeNode root, int node) {
            int dis = 0;
            while (root.val != node) {
                dis ++;
                if (root.val > node) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return dis;
        }

        private boolean check(int[] numbers, int node1, int node2) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i ++) {
                set.add(numbers[i]);
            }
            if (set.contains(node1) && set.contains(node2)) {
                return true;
            }
            return false;
        }

        public int bstDistance(int[] numbers, int node1, int node2) {
            // Write your code here
            if (numbers == null || numbers.length < 2) {
                return -1;
            }
            if (!check(numbers, node1, node2)) {
                return -1;
            }
            TreeNode root = buildTree(numbers);
            while (node1 > root.val && node2 > root.val || node1 < root.val && node2 < root.val) {
                if (node1 > root.val && node2 > root.val) {
                    root = root.right;
                } else {
                    root = root.left;
                }

            }
            return findDis(root, node1) + findDis(root, node2);

        }

    }

}
