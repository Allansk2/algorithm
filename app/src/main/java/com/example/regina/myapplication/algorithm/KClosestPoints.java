package com.example.regina.myapplication.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Allan Zhu on 2019-03-17.
 */
public class KClosestPoints {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public class Solution {
        /**
         * @param points: a list of points
         * @param origin: a point
         * @param k:      An integer
         *
         * @return: the k closest points
         */
        public Point[] kClosest(Point[] points, Point origin, int k) {
            // write your code here
            Point[] ans = new Point[k];
            if (points == null || points.length < k || k <= 0) {
                return new Point[0];
            }

            final Point myOrigin = origin;
            Queue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
                public int compare(Point left, Point right) {
                    int diff = calculateDist(right, myOrigin) - calculateDist(left, myOrigin);
                    if (diff == 0) {
                        diff = right.x - left.x;
                    }
                    if (diff == 0) {
                        diff = right.y - left.y;
                    }
                    return diff;
                }
            });

            for (int i = 0; i < points.length; i++) {
                queue.offer(points[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            for (int i = 0; i < k; i++) {
                ans[k - i - 1] = queue.poll();
            }

            return ans;
        }

        private int calculateDist(Point point, Point origin) {
            return (point.x - origin.x) * (point.x - origin.x) + (point.y - origin.y) * (point.y - origin.y);
        }
    }
}
