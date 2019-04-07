package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.MergeTwoSortedLists.ListNode;


//167. Add Two Numbers
//        中文English
//        You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
//
//        Example
//        Example 1:
//        Input: 7->1->6->null, 5->9->2->null
//        Output: 2->1->9->null
//
//        Explanation:
//        617 + 295 = 912
//        912 to list:  2->1->9->null
//
//
//        Example 2:
//        Input:  3->1->5->null, 5->9->2->null
//        Output: 8->0->8->null
//
//        Explanation:
//        513 + 295 = 808
//        808 to list: 8->0->8->null


public class AddTwoNumbers {

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
            int sum = carry;
            sum += (i != null) ? i.val : 0;
            sum += (j != null) ? j.val : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            i = (i == null) ? i : i.next;
            j = (j == null) ? j : j.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }


}
