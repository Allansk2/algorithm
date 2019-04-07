package com.example.regina.myapplication.algorithm;


//1637. Tree problem
//        中文English
//        Given a tree of n nodes. The ith node's father is fa[i-1] and the value of the ith node is val[i-1]. Especially, 1 represents the root, 2 represents the second node and so on. We gurantee that -1 is the father of root(the first node) which means that fa[0] = -1.
//        The average value of a subtree is the result of the sum of all nodes in the subtree divide by the number of nodes in it.
//        Find the maximum average value of the subtrees in the given tree, return the number which represents the root of the subtree.
//
//        Example
//        Given fa=[-1,1,1,2,2,2,3,3], representing the father node of each point, and val=[100,120,80,40,50,60,50,70] , representing the value of each node, return 1.
//
//        Sample diagram：
//        -1  ------No.1
//        /     \
//        No.2 ----1        1---------No.3
//        /  |  \     /  \
//        2   2   2    3   3
//        No.1 node is (100+120+80+40+50+60+50+70) / 8 = 71.25
//        No.2 node are (120 + 40 + 50 + 60) / 4 = 67.5
//        No.3 node are (80+50+70) / 3 = 66.6667
//        So return 1.
//        Notice
//        the number of nodes do not exceed 100000
//        If there are more than one subtree meeting the requirement, return the minimum number.


// 注意，这个答案不正确，92% test cases passed

public class Treeproblem {

    public class Result {
        int sum = 0;
        int count = 0;

        public Result(final int sum, final int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public class Solution {
        /**
         * @param fa:  the father
         * @param val: the val
         *
         * @return: the biggest node
         */
        public int treeProblem(int[] fa, int[] val) {
            // Write your code here
            int len = fa.length;
            if (len == 0) {
                return 0;
            }

            Result[] mp = new Result[len];
            for (int i = 0; i < len; ++i) {
                mp[i] = new Result(val[i], 1);
            }

            //add the sum and count to the father node
            for (int i = len - 1; i > 0; i--) {  //do not consider fa[0]=-1
                mp[fa[i] - 1].sum += mp[i].sum;
                mp[fa[i] - 1].count += mp[i].count;
            }

            int maxId = -1;
            double maxAve = -Double.MAX_VALUE;

            for (int i = 0; i < len; i++) {
                double ave = (double) mp[i].sum / mp[i].count;
                if (ave > maxAve) {
                    maxId = i;
                    maxAve = ave;
                }
            }
            return maxId + 1;
        }
    }
}
