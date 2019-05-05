package com.example.regina.myapplication.algorithm;

//1272. Kth Smallest Element in a Sorted Matrix
//        中文English
//        Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//        Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//        Example
//        Example1
//
//        Input:
//        [[ 1,  5,  9],[10, 11, 13],[12, 13, 15]]
//        8
//        Output: 13
//        Example2
//
//        Input:
//        [[-5]]
//        1
//        Output: -5
//        Challenge
//        If k << n^2, what's the best algorithm?
//        How about k ~ n^2?
//
//        Notice
//        You may assume k is always valid, 1 ≤ k ≤ n^2.

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaSortedMatrix {

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

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node left, Node right) {
                if (left.val == right.val) {
                    if (left.columnIndex == right.columnIndex) {
                        return left.rowIndex - right.rowIndex;
                    } else {
                        return left.columnIndex - right.columnIndex;
                    }
                } else {
                    return left.val - right.val;
                }
            }
        });

        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        queue.offer(new Node(matrix[0][0], 0, 0));
        visited[0][0] = true;

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return -1;
            }

            Node node = queue.poll();
            if (i == k - 1) {
                return node.val;
            }

            int rowIndex = node.rowIndex;
            int columnIndex = node.columnIndex;
            if (rowIndex < n - 1 && !visited[rowIndex + 1][columnIndex]) {
                queue.offer(new Node(matrix[rowIndex + 1][columnIndex], rowIndex + 1, columnIndex));
                visited[rowIndex + 1][columnIndex] = true;
            }

            if (columnIndex < n - 1 && !visited[rowIndex][columnIndex + 1]) {
                queue.offer(new Node(matrix[rowIndex][columnIndex + 1], rowIndex, columnIndex + 1));
                visited[rowIndex][columnIndex + 1] = true;
            }
        }

        return -1;
    }
}
