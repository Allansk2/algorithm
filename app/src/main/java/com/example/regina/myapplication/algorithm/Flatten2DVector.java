package com.example.regina.myapplication.algorithm;


//601. Flatten 2D Vector
//        中文English
//        Implement an iterator to flatten a 2d vector.
//
//        Example
//        Example 1:
//
//        Input:[[1,2],[3],[4,5,6]]
//        Output:[1,2,3,4,5,6]
//        Example 2:
//
//        Input:[[7,9],[5]]
//        Output:[7,9,5]

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Flatten2DVector {

    public class Vector2D implements Iterator<Integer> {
        Stack<List<Integer>> listStack = new Stack<>();
        Stack<Integer> stackElement = new Stack<>();

        public Vector2D(List<List<Integer>> vec2d) {
            // Initialize your data structure here
            if (vec2d != null) {
                Stack<List<Integer>> temp = new Stack<>();
                for (List<Integer> list : vec2d) {
                    temp.push(list);
                }

                while (!temp.isEmpty()) {
                    listStack.push(temp.pop());
                }
            }
        }

        @Override
        public Integer next() {
            // Write your code here
            if (!hasNext()) {
                return null;
            }

            return stackElement.pop();
        }

        @Override
        public boolean hasNext() {
            // Write your code here
            while (stackElement.isEmpty() && !listStack.isEmpty()) {
                List<Integer> list = listStack.pop();
                Stack<Integer> temp = new Stack<>();
                for (Integer element: list) {
                    temp.push(element);
                }

                while (!temp.isEmpty()) {
                    stackElement.push(temp.pop());
                }
            }

            return !stackElement.isEmpty();
        }

        @Override
        public void remove() {}
    }


}
