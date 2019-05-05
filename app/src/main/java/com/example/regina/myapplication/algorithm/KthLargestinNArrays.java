package com.example.regina.myapplication.algorithm;

//543. Kth Largest in N Arrays
//        中文English
//        Find K-th largest element in N arrays.
//
//        Example
//        Example 1:
//
//        Input:
//        k=3, [[9,3,2,4,7],[1,2,3,4,8]]
//        Output:
//        7
//        Explanation:
//        the 3rd largest element is 7
//
//        Example 2:
//
//        Input:
//        k = 2, [[9,3,2,4,8],[1,2,3,4,2]]
//        Output:
//        8
//        Explanation:
//        the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 4 and etc.
//
//        Notice
//        You can swap elements in the array

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestinNArrays {

    public class Node {
        int rowIndex;
        int val;
        int columnIndex;

        public Node(int val, int rowIndex, int columnIndex) {
            this.val = val;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return -1;
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node left, Node right) {
                if (left.val == right.val) {
                    if (left.columnIndex == right.columnIndex) {
                        return left.rowIndex - right.rowIndex;
                    } else {
                        return right.columnIndex - left.columnIndex;
                    }
                } else {
                    return right.val - left.val;
                }
            }
        });

        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);

            if (arrays[i].length > 0) {
                int columnIndex = arrays[i].length - 1;
                int val = arrays[i][columnIndex];

                queue.offer(new Node(val, i, columnIndex));
            }
        }

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return -1;
            }

            Node node = queue.poll();
            if (i == k - 1) {
                return node.val;
            }

            int rowIndex = node.rowIndex;
            int columnIndex = node.columnIndex - 1;
            if (columnIndex >= 0) {
                queue.offer(new Node(arrays[rowIndex][columnIndex], rowIndex, columnIndex));
            }
        }

        return -1;
    }
}
