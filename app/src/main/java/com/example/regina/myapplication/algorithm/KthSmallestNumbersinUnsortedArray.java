package com.example.regina.myapplication.algorithm;

//461. Kth Smallest Numbers in Unsorted Array
//        中文English
//        Find the kth smallest number in an unsorted integer array.
//
//        Example
//        Example 1:
//
//        Input: [3, 4, 1, 2, 5], k = 3
//        Output: 3
//        Example 2:
//
//        Input: [1, 1, 1], k = 2
//        Output: 1
//        Challenge
//        An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.

public class KthSmallestNumbersinUnsortedArray {
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length < k) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++;
                right--;
            }
        }

        if (right >= k && start <= k) {
            return quickSelect(nums, start, right, k);
        } else if (left <= k && k <= end) {
            return quickSelect(nums, left, end, k);
        } else {
            return nums[k];
        }
    }
}
