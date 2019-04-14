package com.example.regina.myapplication.algorithm;



//134. LRU Cache
//        中文English
//        Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. Finally, you need to return the data from each get
//
//        Example
//        Example1
//
//        Input:
//        LRUCache(2)
//        set(2, 1)
//        set(1, 1)
//        get(2)
//        set(4, 1)
//        get(1)
//        get(2)
//        Output: [1,-1,1]
//        Explanation：
//        cache cap is 2，set(2,1)，set(1, 1)，get(2) and return 1，set(4,1) and delete (1,1)，because （1,1）is the least use，get(1) and return -1，get(2) and return 1.
//        Example 2:
//
//        Input：
//        LRUCache(1)
//        set(2, 1)
//        get(2)
//        set(3, 2)
//        get(2)
//        get(3)
//        Output：[1,-1,2]
//        Explanation：
//        cache cap is 1，set(2,1)，get(2) and return 1，set(3,2) and delete (2,1)，get(2) and return -1，get(3) and return 2.

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }

        Node current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        moveToTail(current);

        return current.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == capacity) {
            // remove head
            Node removeNode = head.next;
            map.remove(removeNode.key);
            head.next = head.next.next;
            head.next.pre = head;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
    }

    private void moveToTail(Node node) {
        node.pre = tail.pre;
        node.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }
}

