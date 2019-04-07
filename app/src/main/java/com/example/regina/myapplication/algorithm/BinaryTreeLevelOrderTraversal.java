package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.SubtreewithMaximumAverage.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//69. Binary Tree Level Order Traversal
//        中文English
//        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        Example
//        Given binary tree {3,9,20,#,#,15,7},
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//
//        return its level order traversal as:
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
//        Challenge
//        Challenge 1: Using only 1 queue to implement it.
//
//        Challenge 2: Use BFS algorithm to do it.
//
//        Notice
//        The first data is the root node, followed by the value of the left and right son nodes, and "#" indicates that there is no child node.


public class BinaryTreeLevelOrderTraversal {

    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List result = new ArrayList();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    level.add(head.val);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
                result.add(level);
            }

            return result;
        }
    }

}
