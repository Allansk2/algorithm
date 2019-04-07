package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.MergeTwoSortedLists.ListNode;


//35. Reverse Linked List
//        中文English
//        Reverse a linked list.
//
//        Example
//        Example1:
//        For linked list 1->2->3, the reversed linked list is 3->2->1
//        Example2:
//        For linked list 1->2->3->4, the reversed linked list is 4->3->2->1
//
//        Challenge
//        Reverse it in-place and in one-pass


public class ReverseLinkedList {

    public class Solution {
        /**
         * @param head: The head of linked list.
         * @return: The new head of reversed linked list.
         */
        public ListNode reverse(ListNode head) {
            //prev表示前继节点
            ListNode prev = null;
            while (head != null) {
                //temp记录下一个节点，head是当前节点
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }

}
