package com.example.regina.myapplication.algorithm;

//434. Number of Islands II
//        中文English
//        Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.
//
//        Example
//        Example 1:
//
//        Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
//        Output: [1,1,2,2]
//        Explanation:
//        0.  00000
//        00000
//        00000
//        00000
//        1.  00000
//        01000
//        00000
//        00000
//        2.  01000
//        01000
//        00000
//        00000
//        3.  01000
//        01000
//        00000
//        00010
//        4.  01000
//        01000
//        00000
//        00011
//        Example 2:
//
//        Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
//        Output: [1,1,2,2]
//        Notice
//        0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

import com.example.regina.myapplication.algorithm.CanReachTheEndpoint.Solution.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberofIslandsII {
    private int convertToIndex(int x, int y, int m) {
        return x * m + y;
    }

    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        public UnionFind(int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int index = convertToIndex(i, j, m);
                    father.put(index, index);
                }
            }
        }

        public int find(int index) {
            if (father.get(index) == index) {
                return index;
            }

            int parent = find(father.get(index));
            father.put(index, parent);
            return parent;
        }

        public boolean union(int indexA, int indexB) {
            int rootA = find(indexA);
            int rootB = find(indexB);
            if (rootA != rootB) {
                father.put(rootA, rootB);
                return true;
            }

            return false;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return ans;
        }

        UnionFind unionFind = new UnionFind(n, m);
        int count = 0;

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        Set<Integer> visited = new HashSet<>();

        for (Point point : operators) {
            int x = point.x;
            int y = point.y;
            int index = convertToIndex(x, y, m);
            if (!visited.contains(index)) {
                count++;
                visited.add(index);

                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    int newIndex = convertToIndex(newX, newY, m);
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && visited.contains(newIndex)) {
                        if (unionFind.union(index, newIndex)) {
                            count--;
                        }
                    }
                }
            }

            ans.add(count);
        }

        return ans;
    }
}
