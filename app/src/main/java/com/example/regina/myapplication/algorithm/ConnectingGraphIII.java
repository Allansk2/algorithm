package com.example.regina.myapplication.algorithm;


//591. Connecting Graph III
//        中文English
//        Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//
//        connect(a, b), an edge to connect node a and node b
//        query(), Returns the number of connected component in the graph
//        Example
//        Example 1:
//
//        Input:
//        ConnectingGraph3(5)
//        query()
//        connect(1, 2)
//        query()
//        connect(2, 4)
//        query()
//        connect(1, 4)
//        query()
//
//        Output:[5,4,3,3]
//
//        Example 2:
//
//        Input:
//        ConnectingGraph3(6)
//        query()
//        query()
//        query()
//        query()
//        query()
//
//
//        Output:
//        [6,6,6,6,6]






public class ConnectingGraphIII {
    int[] father = null;
    int count;

    /*
     * @param n: An integer
     */
    public ConnectingGraphIII(int n) {
        father = new int[n + 1];
        count = n;
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
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
            count--;
        }
    }

    public int query() {
        return count;
    }

    private int find(int x) {
        if (x == father[x]) {
            return x;
        }

        return father[x] = find(father[x]);
    }
}
