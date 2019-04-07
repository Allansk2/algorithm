package com.example.regina.myapplication.algorithm;

//
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//        For example, Given [[0, 30],[5, 10],[15, 20]], return 2.

import com.example.regina.myapplication.algorithm.MeetingRooms.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
            PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
            endTimes.offer(intervals[0].end);
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start >= endTimes.peek()) {
                    endTimes.poll();
                }
                endTimes.offer(intervals[i].end);
            }
            return endTimes.size();

//            if (intervals == null || intervals.length == 0) {
//                return 0;
//            }
//            Comparator<Interval> comp = Comparator.comparing((Interval i) -> i.start);
//            Arrays.sort(intervals, comp);
//            PriorityQueue<Integer> queue = new PriorityQueue<>();
//            queue.offer(intervals[0].end);
//            int count = 1;
//            for (int i = 1; i < intervals.length; i++) {
//                int head = queue.peek();
//                if (intervals[i].start >= head) {
//                    queue.poll();
//                } else {
//                    count++;
//                }
//                queue.offer(intervals[i].end);
//            }
//            return count;
        }
    }
}
