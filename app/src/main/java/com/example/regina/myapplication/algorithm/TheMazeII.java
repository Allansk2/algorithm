package com.example.regina.myapplication.algorithm;

//788. The Maze II
//        中文English
//        There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//        Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
//
//        The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
//
//        Example
//        Example 1:
//        Input:
//        (rowStart, colStart) = (0,4)
//        (rowDest, colDest)= (4,4)
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//        Output:  12
//
//        Explanation:
//        (0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)
//
//        Example 2:
//        Input:
//        (rowStart, colStart) = (0,4)
//        (rowDest, colDest)= (0,0)
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//        Output:  6
//
//        Explanation:
//        (0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
//
//        Notice
//        1.There is only one ball and one destination in the maze.
//        2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//        3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//        4.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }

        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] current = queue.poll();
                if (current[0] == destination[0] && current[1] == destination[1]) {
                    return current[2];
                }

                for (int i = 0; i < 4; i++) {
                    int x = current[0];
                    int y = current[1];
                    int step = current[2];
                    while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                        x += dx[i];
                        y += dy[i];
                        step++;
                    }

                    x -= dx[i];
                    y -= dy[i];
                    step--;

                    if (x == destination[0] && y == destination[1]) {
                        return step;
                    }
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y, step});
                    }
                }
            }
        }

        return -1;
    }
}
