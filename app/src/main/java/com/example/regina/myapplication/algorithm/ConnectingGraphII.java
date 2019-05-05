package com.example.regina.myapplication.algorithm;
//
//590. Connecting Graph II
//        中文English
//        Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//
//        connect(a, b), an edge to connect node a and node b
//        query(a), Returns the number of connected component nodes which include node a.
//        Example
//        Example 1:
//
//        Input:
//        ConnectingGraph2(5)
//        query(1)
//        connect(1, 2)
//        query(1)
//        connect(2, 4)
//        query(1)
//        connect(1, 4)
//        query(1)
//        Output:[1,2,3,3]
//        Example 2:
//
//        Input:
//        ConnectingGraph2(6)
//        query(1)
//        query(2)
//        query(1)
//        query(5)
//        query(1)
//
//        Output:
//        [1,1,1,1,1]

public class ConnectingGraphII {
    int[] father = null;
    int[] size = null;

    /*
     * @param n: An integer
     */
    public ConnectingGraphII(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        int rootA = find(a);
        return size[rootA];
    }

    private int find(int x) {
        if (x == father[x]) {
            return x;
        }

        return father[x] = find(father[x]);
    }
}
