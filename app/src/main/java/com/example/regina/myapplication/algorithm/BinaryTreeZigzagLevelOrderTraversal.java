package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.MaximumSubtree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//71. Binary Tree Zigzag Level Order Traversal
//        中文English
//        Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        Example
//        Example 1:
//
//        Input:
//        {1,2,3}
//        Output:
//        [[1],[3,2]]
//        Explanation:
//        1
//        / \
//        2   3
//        Example 2:
//
//        Input:
//        {3,9,20,#,#,15,7}
//        Output:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
//        Explanation:
//        3
//        / \
//        9  20
//        /  \
//        15   7




public class BinaryTreeZigzagLevelOrderTraversal {
    public class Solution {
        /**
         * @param root: A Tree
         * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            // write your code here
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isReverse = false;
            while (!queue.isEmpty()) {
                List<Integer> subset = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    subset.add(node.val);
                    TreeNode left = node.left;
                    if (left != null) {
                        queue.offer(left);
                    }
                    TreeNode right = node.right;
                    if (right != null) {
                        queue.offer(right);
                    }
                }

                if (isReverse) {
                    Collections.reverse(subset);
                }
                isReverse = !isReverse;
                result.add(subset);
            }

            return result;
        }
    }
}
