package com.example.regina.myapplication.algorithm;

/**
 * Created by Allan Zhu on 2019-04-07.
 */
public class SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n < 0) {
                return null;
            }

            int[][] result = new int[n][n];

            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            boolean[][] checkMatrix = new boolean[n][n];

            int r = 0, c = 0, direction = 0;

            for (int i = 0; i < n * n; i++) {
                result[r][c] = i + 1;
                checkMatrix[r][c] = true;

                int newR = r + dx[direction];
                int newC = c + dy[direction];

                if (newR >= 0 && newR < n && newC >= 0 && newC < n && !checkMatrix[newR][newC]) {
                    r = newR;
                    c = newC;
                } else {
                    direction = (direction + 1) % 4;
                    r = r + dx[direction];
                    c = c + dy[direction];
                }
            }

            return result;
        }
    }
}
