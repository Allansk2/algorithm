package com.example.regina.myapplication.algorithm;


//1360. Symmetric Tree
//        中文English
//        Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        Example
//        Example1
//
//        Input: {1,2,2,3,4,4,3}
//        Output: true
//        Explanation:
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//        This binary tree {1,2,2,3,4,4,3} is symmetric
//        Example2
//
//        Input: {1,2,2,#,3,#,3}
//        Output: false
//        Explanation:
//        1
//        / \
//        2   2
//        \   \
//        3    3
//        This is not a symmetric tree
//        Challenge
//        Could you solve it both recursively and iteratively?

import com.example.regina.myapplication.algorithm.MaximumSubtree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left==null || right==null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
