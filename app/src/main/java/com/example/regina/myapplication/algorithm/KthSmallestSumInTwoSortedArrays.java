package com.example.regina.myapplication.algorithm;

//465. Kth Smallest Sum In Two Sorted Arrays
//        中文English
//        Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
//
//        Example
//        Example 1
//
//        Input:
//        a = [1, 7, 11]
//        b = [2, 4, 6]
//        k = 3
//        Output: 7
//        Explanation: The sums are [3, 5, 7, 9, 11, 13, 13, 15, 17] and the 3th is 7.
//        Example 2
//
//        Input:
//        a = [1, 7, 11]
//        b = [2, 4, 6]
//        k = 4
//        Output: 9
//        Explanation: The sums are [3, 5, 7, 9, 11, 13, 13, 15, 17] and the 4th is 9.
//        Example 3
//
//        Input:
//        a = [1, 7, 11]
//        b = [2, 4, 6]
//        k = 8
//        Output: 15
//        Explanation: The sums are [3, 5, 7, 9, 11, 13, 13, 15, 17] and the 8th is 15.
//        Challenge
//        Do it in either of the following time complexity:
//
//        O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
//        O( (m + n) log maxValue). where maxValue is the max number in A and B.

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestSumInTwoSortedArrays {
    public class Node {
        int val;
        int columnIndex1;
        int columnIndex2;

        public Node(int val, int columnIndex1, int columnIndex2) {
            this.val = val;
            this.columnIndex1 = columnIndex1;
            this.columnIndex2 = columnIndex2;
        }
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node left, Node right) {
                if (left.val == right.val) {
                    if (left.columnIndex1 == right.columnIndex1) {
                        return left.columnIndex2 - right.columnIndex2;
                    } else {
                        return left.columnIndex1 - right.columnIndex1;
                    }
                } else {
                    return left.val - right.val;
                }
            }
        });

        boolean[][] visited = new boolean[A.length][B.length];
        queue.offer(new Node(A[0] + B[0], 0, 0));
        visited[0][0] = true;
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return -1;
            }

            Node node = queue.poll();
            if (i == k - 1) {
                return node.val;
            }

            int columnIndex1 = node.columnIndex1;
            int columnIndex2 = node.columnIndex2;
            for (int j = 0; j < dx.length; j++) {
                int newColumnIndex1 = columnIndex1 + dx[j];
                int newColumnIndex2 = columnIndex2 + dy[j];
                if (newColumnIndex1 < A.length && newColumnIndex2 < B.length && !visited[newColumnIndex1][newColumnIndex2]) {
                    queue.offer(new Node(A[newColumnIndex1] + B[newColumnIndex2], newColumnIndex1, newColumnIndex2));
                    visited[newColumnIndex1][newColumnIndex2] = true;
                }
            }
        }

        return -1;
    }
}
