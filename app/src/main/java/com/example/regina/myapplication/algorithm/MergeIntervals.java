package com.example.regina.myapplication.algorithm;


//156. Merge Intervals
//        中文English
//        Given a collection of intervals, merge all overlapping intervals.
//
//        Example
//        Example 1:
//        Input: [(1,3)]
//        Output: [(1,3)]
//
//        Example 2:
//        Input:  [(1,3),(2,6),(8,10),(15,18)]
//        Output: [(1,6),(8,10),(15,18)]
//
//        Challenge
//        O(n log n) time and O(1) extra space.

import com.example.regina.myapplication.algorithm.MeetingRooms.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public class Solution {
        /**
         * @param intervals: interval list.
         * @return: A new interval list.
         */
        public List<Interval> merge(List<Interval> intervals) {
            // write your code here
            List<Interval> result = new ArrayList<>();
            if (intervals == null || intervals.size() == 0) {
                return result;
            }

            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval left, Interval right) {
                    return left.start - right.start;
                }
            });

            Interval last = null;
            for (Interval interval : intervals) {
                if (last == null || interval.start > last.end) {
                    result.add(interval);
                    last = interval;
                } else {
                    last.end = Math.max(last.end, interval.end);
                }
            }

            return result;
        }
    }
}
