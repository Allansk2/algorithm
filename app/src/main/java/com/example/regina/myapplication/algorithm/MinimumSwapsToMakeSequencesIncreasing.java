package com.example.regina.myapplication.algorithm;



//1016. Minimum Swaps To Make Sequences Increasing
//        中文English
//        We have two integer sequences A and B of the same non-zero length.
//
//        We are allowed to swap elements A[i] and B[i]. Note that both elements are in the same index position in their respective sequences.
//
//        After some number of swaps, A and B are both strictly increasing. (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
//
//        Given A and B, return the minimum number of swaps to make both sequences strictly increasing. It is guaranteed that the given input always makes it possible.
//
//        Example
//        Example 1:
//
//        Input: A = [1,3,5,4], B = [1,2,3,7]
//        Output: 1
//        Explanation: Swap A[3] and B[3]. Then the sequences are:
//        A = [1,3,5,7] and B = [1,2,3,4],
//        which are both strictly increasing.
//        Example 2:
//
//        Input: A = [2,4,5,7,10], B = [1,3,4,5,9]
//        Output: 0
//        Notice
//        A, B are arrays with the same length, and that length will be in the range of [1, 1000].
//        A[i], B[i] are integer values in the range of [0, 2000].




//动态规划.
//
//        设定状态:
//
//        dp[i][0]表示A和B [0, i] 的元素交换至有序, 并且不交换 A[i], B[i] 时的最小交换次数
//        dp[i][1]表示A和B [0, i] 的元素交换至有序, 并且交换 A[i], B[i] 时的最小交换次数
//        因为题目数据保证有解, 所以以下两个条件至少成立其中之一:
//
//        1. A[i] > A[i - 1] && B[i] > B[i - 1]
//        2. A[i] > B[i - 1] && B[i] > A[i - 1]
//        当 1 成立时: dp[i][0] = min(dp[i - 1][0], dp[i][0]), dp[i][1] = min(dp[i - 1] + 1, dp[i][1])
//
//        当 2 成立时: dp[i][0] = min(dp[i][0], dp[i - 1][1]), dp[i][1] = min(dp[i][1], dp[i - 1][0] + 1)
//
//        注意两个条件有可能同时成立.
//
//        边界: 除 dp[0][0] = 0, dp[0][1] = 1 之外, 其他状态初始值均为 INF.



public class MinimumSwapsToMakeSequencesIncreasing {
    class Solution {
        public int minSwap(int[] A, int[] B) {
            if (A == null || B == null || A.length != B.length) {
                return 0;
            }

            int len = A.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = 1;
            for (int i = 1; i < len; i++) {
                dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
                if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
                }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
                }
            }

            return Math.min(dp[len - 1][0], dp[len - 1][1]);
        }
    }

}
