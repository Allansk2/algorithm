package com.example.regina.myapplication.algorithm;


//1565. Modern Ludo I
//        中文English
//        There is a one-dimensional board with a starting point on the far left side of the board and an end point on the far right side of the board. There are several positions on the board that are connected to other positions, ie if A is connected to B, then when chess falls at position A, you can choose whether to move the chess from A to B. And the connection is one way, which means that the chess cannot move from B to A. Now given the length and connections of the board, and you have a six-sided dice(1-6), output the minimum steps to reach the end point.
//
//        Example
//        Example1
//
//        Input: length = 10 and connections = [[2, 10]]
//        Output: 1
//        Explanation:
//        0->2 (dice)
//        2->10(for free)
//        Example2
//
//        Input: length = 15 and connections = [[2, 8],[6, 9]]
//        Output: 2
//        Explanation:
//        0->6 (dice)
//        6->9 (for free)
//        9->15(dice)
//        Notice
//        the index starts from 1.
//        length > 1
//        The starting point is not connected to any other location
//        connections[i][0] < connections[i][1]

import java.util.HashMap;
import java.util.Map;

public class ModernLudoI {
    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] connection : connections) {
            if (!map.containsKey(connection[0])) {
                map.put(connection[0], connection[1]);
            }
            map.put(connection[0], Math.max(connection[1], map.get(connection[0])));
        }

        int[] steps = new int[length + 1];
        steps[1] = 0;
        for (int i = 2; i <= length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i <= length; i++) {
            if (i < 7) {
                steps[i] = 1;
            } else {
                for (int j = 6; j >= 1; j--) {
                    steps[i] = Math.min(steps[i], steps[i - j] + 1);
                }
            }

            if (map.containsKey(i)) {
                int end = map.get(i);
                steps[end] = Math.min(steps[end], steps[i]);
            }

        }


        return steps[length];
    }
}
