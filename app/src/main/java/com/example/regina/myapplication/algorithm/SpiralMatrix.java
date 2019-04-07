package com.example.regina.myapplication.algorithm;

//374. Spiral Matrix
//        中文English
//        Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//        Example
//        Example 1:
//
//        Input:	[[ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ]]
//        Output: [1,2,3,6,9,8,7,4,5]
//        Example 2
//
//        Input:	[[ 6,4,1 ], [ 7,8,9 ]]
//        Output: [6,4,1,9,8,7]

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public class Solution {
        /**
         * @param matrix: a matrix of m x n elements
         *
         * @return: an integer list
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            // write your code here
            List<Integer> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return ans;
            }

            int R = matrix.length, C = matrix[0].length;
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            boolean[][] checkMatrix = new boolean[R][C];

            int r = 0, c = 0, direction = 0;

            for (int i = 0; i < R * C; i++) {
                ans.add(matrix[r][c]);
                checkMatrix[r][c] = true;

                int newR = r + dx[direction];
                int newC = c + dy[direction];

                if (newR >= 0 && newR < R && newC >= 0 && newC < C && !checkMatrix[newR][newC]) {
                    r = newR;
                    c = newC;
                } else {
                    direction = (direction + 1) % 4;
                    r = r + dx[direction];
                    c = c + dy[direction];
                }
            }

            return ans;
        }
    }
}
