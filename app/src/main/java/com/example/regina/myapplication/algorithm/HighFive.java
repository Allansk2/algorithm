package com.example.regina.myapplication.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//613. High Five
//        中文English
//        There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
//
//        Example
//        Example 1:
//
//        Input:
//        [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
//        Output:
//        1: 72.40
//        2: 97.40
//
//        Example 2:
//
//        Input:
//        [[1,90],[1,90],[1,90],[1,90],[1,90],[1,90]]
//        Output:
//        1: 90.00

public class HighFive {
    class Record {
        public int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public class Solution {
        /**
         * @param results a list of <student_id, score>
         *
         * @return find the average of 5 highest scores for each person Map<Integer, Double> (student_id, average_score)
         */
//        public Map<Integer, Double> highFive(Record[] results) {
//            // Write your code here
//            Map<Integer, Double> map = new HashMap<>();
//            if (results == null || results.length == 0) {
//                return map;
//            }
//
//            Map<Integer, Queue<Integer>> scoreMap = new HashMap<>();
//            for (int i = 0; i < results.length; i++) {
//                if (!scoreMap.containsKey(results[i].id)) {
//                    Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
//                        public int compare(Integer left, Integer right) {
//                            return right - left;
//                        }
//                    });
//
//                    scoreMap.put(results[i].id, queue);
//                }
//
//                scoreMap.get(results[i].id).offer(results[i].score);
//            }
//
//            for (Map.Entry<Integer, Queue<Integer>> entry : scoreMap.entrySet()) {
//                int key = entry.getKey();
//                Queue<Integer> queue = entry.getValue();
//                int sum = 0;
//                int count = 0;
//                while (!queue.isEmpty() && count < 5) {
//                    sum += queue.poll();
//                    count++;
//                }
//                double ave = (double)sum / count;
//                map.put(key, ave);
//            }
//
//            return map;




        public Map<Integer, Double> highFive(Record[] results) {
            // Write your code here
            Map<Integer, Double> map = new HashMap<>();
            if (results == null || results.length == 0) {
                return map;
            }

            Map<Integer, Queue<Integer>> scoreMap = new HashMap<>();
            for (int i = 0; i < results.length; i++) {
                if (!scoreMap.containsKey(results[i].id)) {
                    Queue<Integer> queue = new PriorityQueue<>();
                    scoreMap.put(results[i].id, queue);
                }

                Queue<Integer> queue = scoreMap.get(results[i].id);
                if (queue.size() < 5) {
                    queue.offer(results[i].score);
                } else {
                    if (queue.peek() < results[i].score) {
                        queue.poll();
                        queue.offer(results[i].score);
                    }
                }

            }

            for (Map.Entry<Integer, Queue<Integer>> entry : scoreMap.entrySet()) {
                int key = entry.getKey();
                Queue<Integer> queue = entry.getValue();
                int sum = 0;
                int count = 0;
                while (!queue.isEmpty() && count < 5) {
                    sum += queue.poll();
                    count++;
                }
                double ave = (double)sum / count;
                map.put(key, ave);
            }

            return map;
        }

    }
}
