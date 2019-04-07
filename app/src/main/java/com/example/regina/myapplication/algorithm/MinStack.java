package com.example.regina.myapplication.algorithm;

import java.util.Stack;



//12. Min Stack
//        中文English
//        Implement a stack with following functions:
//
//        push(val) push val into the stack
//        pop() pop the top element and return it
//        min() return the smallest number in the stack
//        All above should be in O(1) cost.
//
//        Example
//        Example 1:
//
//        Input:
//        push(1)
//        pop()
//        push(2)
//        push(3)
//        min()
//        push(1)
//        min()
//        Output:
//        1
//        2
//        1
//        Example 2:
//
//        Input:
//        push(1)
//        min()
//        push(2)
//        min()
//        push(3)
//        min()
//        Output:
//        1
//        1
//        1
//        Notice
//        min() will never be called when there is no number in the stack.




public class MinStack {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if (minData.empty()) {
            minData.push(x);
        } else {
            int currentMin = minData.peek();
            if (x < currentMin) {
                minData.push(x);
            } else {
                minData.push(currentMin);
            }
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}
