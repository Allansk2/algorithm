package com.example.regina.myapplication.algorithm;

//178. Graph Valid Tree
//        中文English
//        Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//        Example
//        Example 1:
//
//        Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
//        Output: true.
//        Example 2:
//
//        Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
//        Output: false.
//        Notice
//        You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

public class GraphValidTree {


    public class Solution {
        class UnionFind {
            int[] fa;

            public UnionFind(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
            }

            public int find(int x) {
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

            public void union(int x, int y) {
                int fax = find(x);
                int fay = find(y);

                if (fax != fay) {
                    fa[fax] = fay;
                }
            }
        }


        /**
         * @param n: An integer
         * @param edges: a list of undirected edges
         * @return: true if it's a valid tree, or false
         */
        public boolean validTree(int n, int[][] edges) {
            // write your code here
            if (edges == null || edges.length != n - 1) {
                return false;
            }

            UnionFind unionFind = new UnionFind(n);

            for (int i = 0; i < edges.length; i++) {
                if (unionFind.find(edges[i][0]) == unionFind.find(edges[i][1])) {
                    return false;
                }
                unionFind.union(edges[i][0], edges[i][1]);
            }

            return true;

        }
    }



//    public class Solution {
//        /**
//         * @param n: An integer
//         * @param edges: a list of undirected edges
//         * @return: true if it's a valid tree, or false
//         */
//        public boolean validTree(int n, int[][] edges) {
//            // write your code here
//            if (edges == null || edges.length != n - 1) {
//                return false;
//            }
//
//            Map<Integer, List<Integer>> map = initialMap(n, edges);
//            Set<Integer> checkedNode = new HashSet<>();
//            Queue<Integer> queue = new LinkedList<>();
//            checkedNode.add(0);
//            queue.offer(0);
//            while (!queue.isEmpty()) {
//                for (Integer u: map.get(queue.poll())) {
//                    if (checkedNode.contains(u)) {
//                        continue;
//                    }
//
//                    checkedNode.add(u);
//                    queue.offer(u);
//                }
//            }
//
//            return checkedNode.size() == n;
//        }
//
//        private Map<Integer, List<Integer>> initialMap(int n, int[][] edges) {
//            Map<Integer, List<Integer>> map = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                map.put(i, new ArrayList<Integer>());
//            }
//
//            for (int i = 0; i < edges.length; i++) {
//                int u = edges[i][0];
//                int v = edges[i][1];
//                map.get(u).add(v);
//                map.get(v).add(u);
//            }
//
//            return map;
//        }
//    }
}
