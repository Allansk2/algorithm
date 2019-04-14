package com.example.regina.myapplication.algorithm;

//787. The Maze
//        中文English
//        There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//        Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
//
//        The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
//
//        Example
//        Example 1:
//
//        Input:
//        map =
//        [
//        [0,0,1,0,0],
//        [0,0,0,0,0],
//        [0,0,0,1,0],
//        [1,1,0,1,1],
//        [0,0,0,0,0]
//        ]
//        start = [0,4]
//        end = [3,2]
//        Output:
//        false
//        Example 2:
//
//        Input:
//        map =
//        [[0,0,1,0,0],
//        [0,0,0,0,0],
//        [0,0,0,1,0],
//        [1,1,0,1,1],
//        [0,0,0,0,0]
//        ]
//        start = [0,4]
//        end = [4,4]
//        Output:
//        true
//        Notice
//        1.There is only one ball and one destination in the maze.
//        2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//        3.The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//        5.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    // BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int x = current[0];
                int y = current[1];
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                }

                x -= dx[i];
                y -= dy[i];

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }

    // DFS
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        return helper(maze, visited, start, destination);
    }

    private boolean helper(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        int n = maze.length;
        int m = maze[0].length;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                x += dx[i];
                y += dy[i];
            }

            x -= dx[i];
            y -= dy[i];

            if (!visited[x][y]) {
                visited[x][y] = true;
                if (helper(maze, visited, new int[]{x, y}, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
