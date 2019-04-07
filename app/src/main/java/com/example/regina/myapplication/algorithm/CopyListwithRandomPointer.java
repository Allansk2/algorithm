package com.example.regina.myapplication.algorithm;

import java.util.HashMap;
import java.util.Map;

//105. Copy List with Random Pointer
//  中文English
//        A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//        Return a deep copy of the list.
//
//        Challenge
//        Could you solve it with O(1) space?

public class CopyListwithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public class Solution {
        /**
         * @param head: The head of linked list with a random pointer.
         *
         * @return: A new head of a deep copy of the list.
         */
        public RandomListNode copyRandomList(RandomListNode head) {
            // write your code here
            RandomListNode dummy = new RandomListNode(0);
            RandomListNode newHead = dummy;

            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode newNode;
            while (head != null) {
                if (map.containsKey(head)) {
                    newNode = map.get(head);
                } else {
                    newNode = new RandomListNode(head.label);
                    map.put(head, newNode);
                }
                newHead.next = newNode;

                if (head.random != null) {
                    if (map.containsKey(head.random)) {
                        newNode.random = map.get(head.random);
                    } else {
                        RandomListNode random = new RandomListNode(head.random.label);
                        map.put(head.random, random);
                        newNode.random = random;
                    }
                }

                head = head.next;
                newHead = newHead.next;
            }

            return dummy.next;
        }
    }
}
