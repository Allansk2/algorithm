package com.example.regina.myapplication.algorithm;

//597. Subtree with Maximum Average
//        中文English
//        Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
//
//        Example
//        Example 1
//
//        Input：
//        1
//        /   \
//        -5     11
//        / \   /  \
//        1   2 4    -2
//        Output：11(it's a TreeNode)
//        Example 2
//
//        Input：
//        1
//        /   \
//        -5     11
//        Output：11(it's a TreeNode)
//        Notice
//        LintCode will print the subtree which root is your return node.
//        It's guaranteed that there is only one subtree with maximum average.

public class SubtreewithMaximumAverage {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Solution {
        /**
         * @param root: the root of binary tree
         *
         * @return: the root of the maximum average of subtree
         */
        class Result {
            int sum;
            int count;

            public Result(int sum, int count) {
                this.sum = sum;
                this.count = count;
            }
        }

        Result result = null;
        TreeNode ans;

        public TreeNode findSubtree2(TreeNode root) {
            // write your code here
            if (root == null) {
                return null;
            }

            helper(root);
            return ans;
        }

        private Result helper(TreeNode root) {
            if (root == null) {
                return new Result(0, 0);
            }

            Result left = helper(root.left);
            Result right = helper(root.right);

            Result curr = new Result(left.sum + right.sum + root.val, left.count + right.count + 1);
            if (result == null || curr.sum * result.count > result.sum * curr.count) {
                result = curr;
                ans = root;
            }

            return curr;
        }
    }
}
