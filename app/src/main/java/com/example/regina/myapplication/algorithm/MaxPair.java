package com.example.regina.myapplication.algorithm;


//1635. Max Pair
//        中文English
//        Give two Lists, give a maximum value, find a bunch in each of the two lists, and find all the pairs that are closest to the maximum but not larger than the maximum.
//
//        Example
//        Give a=[2,3,4,5,6], b=[4,5,7], x=8', return [[3,5],[4,4]].
//
//        Explanation:
//        the sum of [3,5] or [4,4] is 8, which is no larger than 8.
//        Give a=[2,3,4,5,6], b=[4,5,7], x=10', return [[3,7],[5,5],[6,4]].
//
//        Explanation:
//        the sum of [3,7],[5,5],[6,4] is 10, which is no larger than 10.
//        Notice
//        The length of the two lists do not exceed 100000100000.
//        Each element do not exceed 10000000001000000000.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPair {
    public class Solution {
        /**
         * @param a: the first list
         * @param b: the second list
         * @param x: the max sum
         * @return: the pairs whose sum are not exceed x
         */
        public int[][] getAns(int[] a, int[] b, int x) {
            // Sort the two arrays
            Arrays.sort(a);
            Arrays.sort(b);

            // First pass, use two pointers to find the max sum <= x
            int p1 = 0;
            int p2 = b.length - 1;
            int maxSum = 0;
            while (p1 < a.length && p2 >= 0) {
                int sum = a[p1] + b[p2];
                if (sum <= x) {
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
            p2 = b.length - 1;
            List<int[]> result = new ArrayList<>();
            while (p1 < a.length && p2 >= 0) {
                int sum = a[p1] + b[p2];
                if (sum <= x) {
                    if (sum == maxSum) {
                        result.add(new int[] {a[p1], b[p2]});
                    }
                    p1++;
                } else {
                    p2--;
                }
            }
            // Convert ArrayList to array
            int[][] resultArray = new int[result.size()][2];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }
            return resultArray;
        }
    }
}
