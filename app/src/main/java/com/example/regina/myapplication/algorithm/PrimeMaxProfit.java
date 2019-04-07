package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Allan Zhu on 2019-03-23.
 */
public class PrimeMaxProfit {

    public static List<List<Integer>> PrimeMaxProfit(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        List<List<Integer>> ans = new ArrayList<>();
        if (forwardRouteList == null || returnRouteList == null || maxTravelDist <= 0) {
            return ans;
        }

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            public int compare(List<Integer> left, List<Integer> right) {
                return left.get(1) - right.get(1);
            }
        };

        Collections.sort(forwardRouteList, comparator);
        Collections.sort(returnRouteList, comparator);


        // First pass, use two pointers to find the max sum <= x
        int p1 = 0;
        int p2 = returnRouteList.size() - 1;
        int maxSum = 0;
        while (p1 < forwardRouteList.size() && p2 >= 0) {
            int sum = forwardRouteList.get(p1).get(1) + returnRouteList.get(p2).get(1);
            if (sum <= maxTravelDist) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                p1++;
            } else {
                p2--;
            }
        }

        // Second pass, use two pointers to find all the pairs whose sum = maxSum
        p1 = 0;
        p2 = returnRouteList.size() - 1;
        while (p1 < forwardRouteList.size() && p2 >= 0) {
            int sum = forwardRouteList.get(p1).get(1) + returnRouteList.get(p2).get(1);
            if (sum <= maxTravelDist) {
                if (sum == maxSum) {
                    int j = p2;
                    while (j >=0 && returnRouteList.get(p2).get(1).equals(returnRouteList.get(j).get(1))) {
                        List<Integer> subset = new ArrayList<>();
                        subset.add(forwardRouteList.get(p1).get(0));
                        subset.add(returnRouteList.get(j).get(0));
                        ans.add(subset);
                        j--;
                    }
                }
                p1++;
            } else {
                p2--;
            }
        }

        return ans;
    }


}
