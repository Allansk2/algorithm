package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//629. Minimum Spanning Tree
//        中文English
//        Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them), find some edges, connect all the cities and spend the least amount.
//        Return the connects if can connect all the cities, otherwise return empty list.
//
//        Example
//        Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
//
//        Return ["Acity","Bcity",1], ["Acity","Ccity",2]
//
//        Notice
//        Return the connections sorted by the cost, or sorted city1 name if their cost is same, or sorted city2 if their city1 name is also same.

public class MinimumSpanningTree {
    public class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public class Solution {
        /**
         * @param connections given a list of connections include two cities and cost
         *
         * @return a list of connections from results
         */
        public List<Connection> lowestCost(List<Connection> connections) {
            // Write your code here
            if (connections == null) {
                return null;
            }

            Collections.sort(connections, new Comparator<Connection>() {
                public int compare(Connection a, Connection b) {
                    if (a.cost != b.cost) {
                        return a.cost - b.cost;
                    }
                    if (a.city1.equals(b.city1)) {
                        return a.city2.compareTo(b.city2);
                    }

                    return a.city1.compareTo(b.city1);
                }
            });

            int n = 0;
            Map<String, Integer> map = new HashMap<>();
            for (Connection connection : connections) {
                if (!map.containsKey(connection.city1)) {
                    map.put(connection.city1, ++n);
                }
                if (!map.containsKey(connection.city2)) {
                    map.put(connection.city2, ++n);
                }
            }

            List<Connection> ans = new ArrayList<>();
            int[] father = new int[n + 1];
            for (Connection connection : connections) {
                int num1 = map.get(connection.city1);
                int num2 = map.get(connection.city2);
                int root1 = findParent(num1, father);
                int root2 = findParent(num2, father);

                if (root1 != root2) {
                    ans.add(connection);
                    father[num1] = root2;
                }
            }

            if (ans.size() == n - 1) {
                return ans;
            }
            return new ArrayList<>();
        }

        private int findParent(int num, int[] father) {
            if (father[num] == 0) {
                return 0;
            }

            return father[num] = findParent(father[num], father);
        }
    }
}
