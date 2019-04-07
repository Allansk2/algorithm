package com.example.regina.myapplication.algorithm;

import com.example.regina.myapplication.algorithm.MergeTwoSortedLists.ListNode;



//380. Intersection of Two Linked Lists
//        中文English
//        Write a program to find the node at which the intersection of two singly linked lists begins.
//
//        Example
//        Example 1:
//
//        Input:
//        A:          a1 → a2
//        ↘
//        c1 → c2 → c3
//        ↗
//        B:     b1 → b2 → b3
//        Output: c1
//        Explanation ：begin to intersect at node c1.
//        Challenge
//        Your code should preferably run in O(n) time and use only O(1) memory.
//
//        Notice
//        If the two linked lists have no intersection at all, return null.
//        The linked lists must retain their original structure after the function returns.
//        You may assume there are no cycles anywhere in the entire linked structure.


public class IntersectionofTwoLinkedLists {
    public class Solution {
        /**
         * @param headA: the first list
         * @param headB: the second list
         *
         * @return: a ListNode
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);

            if (lengthA > lengthB) {
                headA = moveListNode(lengthA - lengthB, headA);
            } else {
                headB = moveListNode(lengthB - lengthA, headB);
            }

            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }

            return null;
        }

        private int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                head = head.next;
                length++;
            }
            return length;
        }

        private ListNode moveListNode(int length, ListNode head) {
            while (head != null && length-- > 0) {
                head = head.next;
            }
            return head;
        }
    }
}
