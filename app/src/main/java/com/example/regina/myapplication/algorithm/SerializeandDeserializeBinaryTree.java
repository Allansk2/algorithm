package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.SubtreewithMaximumAverage.TreeNode;

import java.util.ArrayList;
import java.util.List;


//7. Serialize and Deserialize Binary Tree
//        中文English
//        Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
//
//        Example
//        Example 1:
//
//        Input:
//        Binary tree {3,9,20,#,#,15,7},  denote the following structure:
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Example 2:
//
//        Input:
//        Binary tree {1,2,3},  denote the following structure:
//        1
//        / \
//        2   3
//        Our data serialization use BFS traversal. This is just for when you got Wrong Answer and want to debug the input.
//
//        You can use other method to do serializaiton and deserialization.
//
//        Notice
//        There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.


public class SerializeandDeserializeBinaryTree {

    public class Solution {
        int position = 0;
        /**
         * This method will be invoked first, you should design your own algorithm
         * to serialize a binary tree which denote by a root node to a string which
         * can be easily deserialized by your own "deserialize" method later.
         */
        public String serialize(TreeNode root) {
            // write your code here
            if (root == null) {
                return null;
            }

            List<String> result = new ArrayList<>();
            transver(root, result);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                if (i != (result.size() - 1)) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        private void transver(TreeNode root, List<String> result) {
            if (root == null) {
                result.add("#");
                return;
            }
            result.add(String.valueOf(root.val));
            transver(root.left, result);
            transver(root.right, result);
        }

        /**
         * This method will be invoked second, the argument data is what exactly
         * you serialized at method "serialize", that means the data is not given by
         * system, it's given by your own serialize method. So the format of data is
         * designed by yourself, and deserialize it here as you serialize it in
         * "serialize" method.
         */
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }

            String[] values = data.split(",");
            if (values.length == 0) {
                return null;
            }
            position = 0;
            return deserializeInternal(values);
        }

        private TreeNode deserializeInternal(String[] values) {
            if (position < values.length) {
                String val = values[position];
                if (val.equals("#")) {
                    return null;
                }

                int intValue = Integer.parseInt(val);
                TreeNode root = new TreeNode(intValue);
                position++;
                TreeNode left = deserializeInternal(values);
                position++;
                TreeNode right = deserializeInternal(values);
                root.left = left;
                root.right = right;

                return root;
            }
            return null;
        }


    }


}
