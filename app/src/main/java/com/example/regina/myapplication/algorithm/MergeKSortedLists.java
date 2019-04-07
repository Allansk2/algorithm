package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.MergeTwoSortedLists.ListNode;

import java.util.List;


// 104. Merge K Sorted Lists
//         中文English
//         Merge k sorted linked lists and return it as one sorted list.
//
//         Analyze and describe its complexity.
//
//         Example
//         Example 1:
//         Input:   [2->4->null,null,-1->null]
//         Output:  -1->2->4->null
//
//         Example 2:
//         Input: [2->6->null,5->null,7->null]
//         Output:  2->5->6->7->null

class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        return helper(0, lists.size() - 1, lists);
    }

    private ListNode helper(int start, int end, List<ListNode> lists) {
        if (start == end) {
            return lists.get(start);
        }

        int middle = (start + end) / 2;
        ListNode left = helper(start, middle, lists);
        ListNode right = helper(middle + 1, end, lists);
        return mergeTwoList(left, right);
    }


    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode dum = head;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                dum.next = left;
                left = left.next;
            }else {
                dum.next = right;
                right = right.next;
            }
            dum = dum.next;
        }

        while(left != null) {
            dum.next = left;
            dum = dum.next;
            left = left.next;
        }

        while(right != null) {
            dum.next = right;
            dum = dum.next;
            right = right.next;
        }

        return head.next;
    }

}