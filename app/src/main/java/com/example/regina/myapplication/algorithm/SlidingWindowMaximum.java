package com.example.regina.myapplication.algorithm;


//362. Sliding Window Maximum
//        中文English
//        Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.
//
//        Example
//        For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
//
//        At first the window is at the start of the array like this
//
//        [|1, 2, 7| ,7, 8] , return the maximum 7;
//
//        then the window move one step forward.
//
//        [1, |2, 7 ,7|, 8], return the maximum 7;
//
//        then the window move one step forward again.
//
//        [1, 2, |7, 7, 8|], return the maximum 8;
//
//        Challenge
//        o(n) time and O(k) memory

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SlidingWindowMaximum {

    public class Solution {
        class Node {
            int pos;
            int val;
            public Node(int pos, int val) {
                this.pos = pos;
                this.val = val;
            }
        }
        /**
         * @param nums: A list of integers.
         * @param k: An integer
         * @return: The maximum number inside the window at each moving.
         */
        public List<Integer> maxSlidingWindow(int[] nums, int k) {
            // write your code here
            List<Integer> ans = new ArrayList<>();
            if (nums == null || k <= 0 || nums.length < k) {
                return ans;
            }

            Comparator<Node> comparator = new Comparator<Node>() {
                public int compare(Node left, Node right) {
                    if (right.val == left.val) {
                        return left.pos - right.pos;
                    }

                    return right.val - left.val;
                }
            };

            TreeSet<Node> set = new TreeSet(comparator);
            for (int i = 0; i < nums.length; i++) {
                set.add(new Node(i, nums[i]));

                if (set.size() > k) {
                    Node last = new Node(i - k, nums[i - k]);
                    set.remove(last);
                }
                if (set.size() == k) {
                    ans.add(set.first().val);
                }
            }

            return ans;
        }
    }

}
