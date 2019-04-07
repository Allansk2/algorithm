package com.example.regina.myapplication.algorithm;

import java.util.LinkedList;
import java.util.Queue;


//611. Knight Shortest Path
//        中文English
//        Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
//        Return -1 if destination cannot be reached.
//
//        Example
//        Example 1:
//
//        Input:
//        [[0,0,0],
//        [0,0,0],
//        [0,0,0]]
//        source = [2, 0] destination = [2, 2]
//        Output: 2
//        Explanation:
//        [2,0]->[0,1]->[2,2]
//        Example 2:
//
//        Input:
//        [[0,1,0],
//        [0,0,1],
//        [0,0,0]]
//        source = [2, 0] destination = [2, 2]
//        Output:-1
//        Clarification
//        If the knight is at (x, y), he can get to the following positions in one step:
//
//        (x + 1, y + 2)
//        (x + 1, y - 2)
//        (x - 1, y + 2)
//        (x - 1, y - 2)
//        (x + 2, y + 1)
//        (x + 2, y - 1)
//        (x - 2, y + 1)
//        (x - 2, y - 1)
//        Notice
//        source and destination must be empty.
//        Knight can not enter the barrier.


public class KnightShortestPath {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public class Solution {
        /**
         * @param grid:        a chessboard included 0 (false) and 1 (true)
         * @param source:      a point
         * @param destination: a point
         *
         * @return: the shortest path
         */
        public int shortestPath(boolean[][] grid, Point source, Point destination) {
            // write your code here
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            if (source == null || destination == null) {
                return -1;
            }

            if (source.x == destination.x && source.y == destination.y) {
                return 0;
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(source);
            grid[source.x][source.y] = true;

            int count = 0;
            while (!queue.isEmpty()) {
                int N = queue.size();
                for (int i = 0; i < N; i++) {
                    Point point = queue.poll();
                    addPoint(queue, point, grid);
                    if (point.x == destination.x && point.y == destination.y) {
                        return count;
                    }
                }
                count++;
            }

            return -1;
        }

        private void addPoint(Queue<Point> queue, Point point, boolean[][] grid) {
            int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
            int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

            for (int i = 0; i < 8; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !grid[x][y]) {
                    grid[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
}
