package com.example.regina.myapplication.algorithm;

//1562. Number of restaurants
//        中文English
//        Give a List of data representing the coordinates[x,y] of each restaurant and the customer is at the origin[0,0]. Find n closest restaurants to the customer, where m is the furthest distance from n restaurants to the customer. If there are more than n restaurants in the list and the distance from the customer is not greater than m, then the first n restaurants will be returned in the order of the elements in the list.
//
//        Example
//        Example 1
//
//        Input: n = 2 , List = [[0,0],[1,1],[2,2]]
//        Output : [[0,0],[1,1]]
//        Explanation: The closest 2 restaurants are [0,0] and [1,1]. And only these two restaurants are in sqrt(2) meters.
//        Example 2
//
//        Input: n = 3,List = [[0,1],[1,2],[2,1],[1,0]]
//        Output:[[0,1],[1,2],[2,1]]
//        Explanation: The closest 3 restaurants are [0,1],[1,2] and [2,1]. And only these three restaurants are in sqrt(5) meters.
//        Notice
//        1.Coordinates in range [-1000,1000]
//        2.n>0
//        3.No same coordinates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numberofrestaurants {

    public class Solution {
        /**
         * @return: nothing
         */
        public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
            // Write your code here
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (restaurant == null || restaurant.size() == 0 || n > restaurant.size()) {
                return result;
            }
            int L = restaurant.size();
            int[] distance = new int[L];
            for (int i = 0; i < L; i++) {
                int x = restaurant.get(i).get(0);
                int y = restaurant.get(i).get(1);
                int dis = x * x + y * y;
                distance[i] = dis;
            }
            Arrays.sort(distance);
            int count = 0;
            for (int i = 0; i < L; i++) {
                int x = restaurant.get(i).get(0);
                int y = restaurant.get(i).get(1);
                int dis = x * x + y * y;
                if (dis <= distance[n - 1]) {
                    result.add(restaurant.get(i));
                    count++;
                }
                if (count == n) {
                    break;
                }
            }
            return result;
        }
    }
}
