package com.example.regina.myapplication.algorithm;

//589. Connecting Graph
//        中文English
//        Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//
//        connect(a, b), add an edge to connect node a and node b`.
//query(a, b), check if two nodes are connected
//Example
//Example 1:
//
//Input:
//ConnectingGraph(5)
//query(1, 2)
//connect(1, 2)
//query(1, 3)
//connect(2, 4)
//query(1, 4)
//Output:
//[false,false,true]
//
//Example 2:
//
//Input:
//ConnectingGraph(6)
//query(1, 2)
//query(2, 3)
//query(1, 3)
//query(5, 6)
//query(1, 4)
//
//Output:
//[false,false,false,false,false]

public class ConnectingGraph {
    int[] fa;

    /*
     * @param n: An integer
     */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    private int find(int x) {
        int parent = fa[x];
        while (parent != fa[parent]) {
            parent = fa[parent];
        }

        int tmp = -1;
        int father = fa[x];
        while (father != fa[father]) {
            tmp = fa[father];
            fa[father] = parent;
            father = tmp;
        }

        fa[x] = parent;
        return parent;
    }

    private void union(int x, int y) {
        int fax = find(x);
        int fay = find(y);

        if (fax != fay) {
            fa[fax] = fay;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        if (find(a - 1) == find(b - 1)) {
            return;
        }
        union(a - 1, b - 1);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a - 1) == find(b - 1);
    }
}
