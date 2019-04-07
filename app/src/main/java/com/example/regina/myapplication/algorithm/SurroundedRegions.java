package com.example.regina.myapplication.algorithm;


//477. Surrounded Regions
//        中文English
//        Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//        A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
//
//        Example
//        Example 1:
//
//        Input:
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        Output:
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//        Example 2:
//
//        Input:
//        X X X X
//        X O O X
//        X O O X
//        X O X X
//        Output:
//        X X X X
//        X O O X
//        X O O X
//        X O X X


//方法:
//
//        从每个边界的 'O' 开始遍历, 只访问 'O', 先都暂时设置为 'T' 或其他字符.
//
//        遍历结束之后, 将剩下的 'O' 替换为 'X' 然后再将 'T' 还原即可.

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    class Solution {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }

            int n = board.length, m = board[0].length;
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    bfs(i, 0, board);
                }
                if (board[i][m - 1] == 'O') {
                    bfs(i, m - 1, board);
                }
            }

            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O') {
                    bfs(0, i, board);
                }
                if (board[n - 1][i] == 'O') {
                    bfs(n - 1, i, board);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'Y') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void bfs(int i, int j, char[][] board) {
            board[i][j] = 'Y';
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, j});
            while (!queue.isEmpty()) {
                int[] positions = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = positions[0] + dx[k];
                    int y = positions[1] + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                        board[x][y] = 'Y';
                        queue.offer(new int[]{x, y});
                    }
                }
            }

        }
    }

}
