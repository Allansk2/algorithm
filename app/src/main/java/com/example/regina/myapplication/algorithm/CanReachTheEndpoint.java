package com.example.regina.myapplication.algorithm;


//1479. Can Reach The Endpoint
//        中文English
//        Given a map size of m*n, 1 means space, 0 means obstacle, 9 means the endpoint. You start at (0,0) and return whether you can reach the endpoint.
//
//        Example
//        Example1
//
//        Input:
//        [
//        [1,1,1],
//        [1,1,1],
//        [1,1,9]
//        ]
//        Output: true
//        Example2
//
//        Input:
//        [
//        [1,1,1],
//        [1,0,0],
//        [1,0,9]
//        ]
//        Output: false

import java.util.LinkedList;
import java.util.Queue;

public class CanReachTheEndpoint {
    public class Solution {
        class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] dx = new int[]{0, 0 , 1, -1};
        int[] dy = new int[]{1, -1 , 0, 0};

        /**
         * @param map: the map
         * @return: can you reach the endpoint
         */
        public boolean reachEndpoint(int[][] map) {
            // Write your code here
            if (map == null || map.length == 0 || map[0].length == 0) {
                return true;
            }

            if (map[0][0] == 9) {
                return true;
            } else if (map[0][0] == 0) {
                return false;
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            map[0][0] = 0;

            int m = map.length;
            int n = map[0].length;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = point.x + dx[i];
                    int y = point.y + dy[i];
                    if (x >=0 && x < m && y >= 0 && y < n) {
                        if (map[x][y] == 9) {
                            return true;
                        } else if (map[x][y] == 1) {
                            map[x][y] = 0;
                            queue.offer(new Point(x, y));
                        }
                    }
                }
            }

            return false;
        }
    }
}
