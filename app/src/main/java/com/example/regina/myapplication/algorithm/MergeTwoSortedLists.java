package com.example.regina.myapplication.algorithm;

//165. Merge Two Sorted Lists
//        中文English
//        Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
//
//        Example
//        Example 1:
//        Input: list1 = null, list2 = 0->3->3->null
//        Output: 0->3->3->null
//
//
//        Example 2:
//        Input:  list1 =  1->3->8->11->15->null, list2 = 2->null
//        Output: 1->2->3->8->11->15->null

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        /**
         * @param l1: ListNode l1 is the head of the linked list
         * @param l2: ListNode l2 is the head of the linked list
         *
         * @return: ListNode head of linked list
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // write your code here
            ListNode dummp = new ListNode(0);
            ListNode root = dummp;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    dummp.next = l1;
                    l1 = l1.next;
                } else {
                    dummp.next = l2;
                    l2 = l2.next;
                }
                dummp = dummp.next;
            }

            if (l1 != null) {
                dummp.next = l1;
            } else {
                dummp.next = l2;
            }

            return root.next;
        }
    }
}
