package com.example.regina.myapplication.algorithm;


//464. Sort Integers II
//        中文English
//        Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
//
//        Example
//        Example1:
//
//        Input: [3, 2, 1, 4, 5],
//        Output: [1, 2, 3, 4, 5].
//        Example2:
//
//        Input: [2, 3, 1],
//        Output: [1, 2, 3].


public class SortIntegersII {

    public class Solution {
        /**
         * @param A: an integer array
         * @return: nothing
         */
        public void sortIntegers2(int[] A) {
            // write your code here
            if (A == null || A.length == 0) {
                return;
            }

            sort(A, 0, A.length - 1);
        }

        private void sort(int[] A, int start, int end) {
            if (start >= end) {
                return;
            }

            int mid = (start + end) / 2;
            int left = start, right = end;
            int pivate = A[mid];
            while (left <= right) {
                while (left <= right && A[left] < pivate) {
                    left++;
                }

                while (left <= right && A[right] > pivate) {
                    right--;
                }

                if (left <= right) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;

                    left++;
                    right--;
                }

            }

            sort(A, start, right);
            sort(A, left, end);

        }
    }


}
