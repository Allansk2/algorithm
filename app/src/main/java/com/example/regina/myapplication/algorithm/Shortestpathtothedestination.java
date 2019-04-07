package com.example.regina.myapplication.algorithm;


//1563. Shortest path to the destination
//        中文English
//        Given a 2D array representing the coordinates on the map, there are only values 0, 1, 2 on the map. value 0 means that it can pass, value 1 means not passable, value 2 means target place. Starting from the coordinates [0,0],You can only go up, down, left and right. Find the shortest path that can reach the destination, and return the length of the path.
//
//        Example
//        Example 1
//
//        Input:
//        [
//        [0, 0, 0],
//        [0, 0, 1],
//        [0, 0, 2]
//        ]
//        Output: 4
//        Explanation: [0,0] -> [1,0] -> [2,0] -> [2,1] -> [2,2]
//        Example 2
//
//        Input:
//        [
//        [0,1],
//        [0,1],
//        [0,0],
//        [0,1]
//        ]
//        Output: 4
//        Explanation: [0,0] -> [1,0] -> [2,0] -> [3,0] -> [3,1]
//        Notice
//        1.The map must exist and is not empty, there is only one target

import java.util.LinkedList;
import java.util.Queue;

public class Shortestpathtothedestination {

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
         * @param targetMap:
         * @return: nothing
         */
        public int shortestPath(int[][] targetMap) {
            // Write your code here
            if (targetMap == null || targetMap.length == 0 || targetMap[0].length == 0) {
                return 0;
            }


            if (targetMap[0][0] == 2) {
                return 0;
            } else if (targetMap[0][0] == 1) {
                return -1;
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            targetMap[0][0] = 1;

            int m = targetMap.length;
            int n = targetMap[0].length;
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Point point = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int x = point.x + dx[i];
                        int y = point.y + dy[i];
                        if (x >=0 && x < m && y >= 0 && y < n) {
                            if (targetMap[x][y] == 2) {
                                return step + 1;
                            } else if (targetMap[x][y] == 0) {
                                targetMap[x][y] = 1;
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
                step++;
            }

            return -1;

        }
    }
}
