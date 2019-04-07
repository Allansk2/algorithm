package com.example.regina.myapplication.algorithm;

//628. Maximum Subtree
//        中文English
//        Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
//
//        Example
//        Example 1:
//
//        Input :
//        1
//        /   \
//        -5     2
//        / \   /  \
//        0   3 -4  -5
//        Output : 3
//        Notice
//        LintCode will print the subtree which root is your return node.
//        It's guaranteed that there is only one subtree with maximum sum and the given binary tree is not an empty tree.


public class MaximumSubtree {

    public class TreeNode {
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
         * @return: the maximum weight node
         */
        int maxSum = Integer.MIN_VALUE;
        TreeNode ans = null;

        public TreeNode findSubtree(TreeNode root) {
            // write your code here
            if (root == null) {
                return null;
            }
            helper(root);

            return ans;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = helper(root.left);
            int rightSum = helper(root.right);
            int currentSum = leftSum + rightSum + root.val;

            if (currentSum > maxSum) {
                maxSum = currentSum;
                ans = root;
            }

            if (leftSum > maxSum) {
                maxSum = leftSum;
                ans = root.left;
            }

            if (rightSum > maxSum) {
                maxSum = rightSum;
                ans = root.right;
            }

            return currentSum;
        }
    }
}
