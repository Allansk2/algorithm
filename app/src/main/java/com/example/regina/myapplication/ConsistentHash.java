package com.example.regina.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Allan Zhu on 2019-03-13.
 */
public class ConsistentHash {
    private Map<String, NavigableMap<Integer, String>> hash;

    public void consistentHash(int n) {

    }

    public class MiniCassandra {
        Map<String, NavigableMap<Integer, String>> map;

        public MiniCassandra() {
            // do intialization if necessary
            map = new HashMap<>();
        }

        /*
         * @param raw_key: a string
         * @param column_key: An integer
         * @param column_value: a string
         * @return: nothing
         */
        public void insert(String row_key, int column_key, String value) {
            // write your code here
            if (!map.containsKey(row_key)) {
                map.put(row_key, new TreeMap<Integer, String>());
            }
            map.get(row_key).put(column_key, value);
        }

        /*
         * @param row_key: a string
         * @param column_start: An integer
         * @param column_end: An integer
         * @return: a list of Columns
         */
        public List<Column> query(String row_key, int column_start, int column_end) {
            // write your code here
            List<Column> result = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : map.get(row_key).subMap(column_start, true, column_end, true).entrySet()) {
                result.add(new Column(entry.getKey(), entry.getValue()));
            }
            return result;
        }
    }

    public class Column {
        public int key;
        public String value;

        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
