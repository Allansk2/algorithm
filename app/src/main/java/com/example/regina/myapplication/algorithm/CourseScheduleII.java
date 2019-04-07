package com.example.regina.myapplication.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//616. Course Schedule II
//        中文English
//        There are a total of n courses you have to take, labeled from 0 to n - 1.
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        Example
//        Example 1:
//
//        Input: n = 2, prerequisites = [[1,0]]
//        Output: [0,1]
//        Example 2:
//
//        Input: n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
//        Output: [0,1,2,3] or [0,2,1,3]

public class CourseScheduleII {

    public class Solution {
        /*
         * @param numCourses: a total of n courses
         * @param prerequisites: a list of prerequisite pairs
         * @return: the course order
         */
//        public int[] findOrder(int numCourses, int[][] prerequisites) {
//            // write your code here
//            int[] courses = new int[numCourses];
//            for (int i = 0; i < numCourses; i++) {
//                courses[i] = i;
//            }
//
//            if (prerequisites == null || prerequisites.length == 0) {
//                return courses;
//            }
//
//            Map<Integer, List<Integer>> graph = new HashMap<>();
//            int[] inputDegree = new int[numCourses];
//            for (int i = 0; i < prerequisites.length; i++) {
//                inputDegree[prerequisites[i][0]]++;
//                if (!graph.containsKey(prerequisites[i][1])) {
//                    graph.put(prerequisites[i][1], new ArrayList<Integer>());
//                }
//                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
//            }
//
//            int pos = 0;
//            while (pos < numCourses) {
//                int index = -1;
//                for (int i = 0; i < numCourses; i++) {
//                    if (inputDegree[i] == 0) {
//                        index = i;
//                        break;
//                    }
//                }
//
//                if (index == -1) {
//                    break;
//                }
//
//                inputDegree[index] = -1;
//                courses[pos] = index;
//                pos++;
//
//                List<Integer> list = graph.get(index);
//                if (list != null) {
//                    for (Integer j : list) {
//                        inputDegree[j]--;
//                    }
//                }
//            }
//
//            if (pos < numCourses) {
//                return new int[0];
//            }
//            return courses;
//        }




        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // write your code here
            int[] courses = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = i;
            }

            if (prerequisites == null || prerequisites.length == 0) {
                return courses;
            }

            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] inputDegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                inputDegree[prerequisites[i][0]]++;
                if (!graph.containsKey(prerequisites[i][1])) {
                    graph.put(prerequisites[i][1], new ArrayList<Integer>());
                }
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inputDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int index = queue.poll();
                courses[count] = index;
                count++;

                List<Integer> list = graph.get(index);
                if (list != null) {
                    for (Integer j : list) {
                        inputDegree[j]--;
                        if (inputDegree[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            }

            if (count < numCourses) {
                return new int[0];
            }
            return courses;
        }



    }
}
