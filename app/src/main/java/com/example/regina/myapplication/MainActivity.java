package com.example.regina.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MainActivity extends Activity {

    @TargetApi (VERSION_CODES.O)
    @RequiresApi (api = VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] edges = new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };

        final Solution solution = new Solution();
        final boolean b = solution.validTree(5, edges);
        int a = 0;
    }

    public class Solution {
        /**
         * @param n an integer
         * @param edges a list of undirected edges
         * @return true if it's a valid tree, or false
         */
        public boolean validTree(int n, int[][] edges) {
            if (n == 0) {
                return false;
            }

            if (edges.length != n - 1) {
                return false;
            }

            Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

            // bfs
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> hash = new HashSet<>();

            queue.offer(0);
            hash.add(0);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (Integer neighbor : graph.get(node)) {
                    if (hash.contains(neighbor)) {
                        continue;
                    }
                    hash.add(neighbor);
                    queue.offer(neighbor);
                }
            }

            return (hash.size() == n);
        }

        private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new HashSet<Integer>());
            }

            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            return graph;
        }
    }
}


