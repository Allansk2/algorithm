package com.example.regina.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MainActivity extends Activity {

    @TargetApi (VERSION_CODES.O)
    @RequiresApi (api = VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] arrays = new int[][]{
                {},
                {},
                {1},
                {1, 2, 3, 4},
                {11, 10, 9, 8, 7}
        };

        final int i = KthInArrays(arrays, 5);
        int a = 0;
    }

    public class Node {
        int rowIndex;
        int val;
        int columnIndex;

        public Node(int val, int rowIndex, int columnIndex) {
            this.val = val;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return -1;
        }

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node left, Node right) {
                if (left.val == right.val) {
                    if (left.columnIndex == right.columnIndex) {
                        return left.rowIndex - right.rowIndex;
                    } else {
                        return right.columnIndex - left.columnIndex;
                    }
                } else {
                    return right.val - left.val;
                }
            }
        });

        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);

            if (arrays[i].length > 0) {
                int columnIndex = arrays[i].length - 1;
                int val = arrays[i][columnIndex];

                queue.offer(new Node(val, i, columnIndex));
            }
        }

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return -1;
            }

            Node node = queue.poll();
            if (i == k - 1) {
                return node.val;
            }

            int rowIndex = node.rowIndex;
            int columnIndex = node.columnIndex - 1;
            if (columnIndex >= 0) {
                queue.offer(new Node(arrays[rowIndex][columnIndex], rowIndex, columnIndex));
            }
        }

        return -1;
    }
}


