package com.example.regina.myapplication.algorithm;


//469. Same Tree
//        中文English
//        Check if two binary trees are identical. Identical means the two binary trees have the same structure and every identical position has the same value.
//
//        Example
//        Example 1:
//
//        Input:{1,2,2,4},{1,2,2,4}
//        Output:true
//        Explanation:
//        1             1
//        / \           / \
//        2   2   and   2   2
//        /             /
//        4             4
//
//        are identical.
//        Example 2:
//
//        Input:{1,2,3,4},{1,2,3,#,4}
//        Output:false
//        Explanation:
//
//        1             1
//        / \           / \
//        2   3   and   2   3
//        /               \
//        4                 4
//
//        are not identical.

import com.example.regina.myapplication.algorithm.MaximumSubtree.TreeNode;

public class SameTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q != null || p != null && q == null) {
                return false;
            }
            if (p == null && q == null) {
                return true;
            }

            boolean left = isSameTree(p.left, q.left);
            if (!left) {
                return false;
            }
            boolean current = p.val == q.val;
            if (!current) {
                return false;
            }

            return isSameTree(p.right, q.right);
        }
    }
}
