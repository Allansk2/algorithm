package com.example.regina.myapplication.algorithm;


//1380. Log Sorting
//        中文English
//        Give a log, consisting of List< String >, each element representing one line of logs. Each line of log information is separated by a space. The first is the ID of the log, followed by the log content.
//        There are two ways to make content:
//
//        All consist of letters and spaces.
//        All consist of numbers and spaces.
//        Now that the logs are sorted, it is required that component 1 be sorted in order of content lexicography and placed at the top, and component 2 should be placed at the bottom and output in the order of input. (Note that the space also belongs to the content, and when the lexicographic order of the composition method 1 is equal, sort according to the dictionary order of log ID., and the guarantee ID is not repeated)
//        Example
//        Example1
//
//        Input:
//        list = [
//        "zo4 4 7",
//        "a100 Act zoo",
//        "a1 9 2 3 1",
//        "g9 act car"
//        ]
//        Output:
//        [
//        "a100 Act zoo",
//        "g9 act car",
//        "zo4 4 7",
//        "a1 9 2 3 1"
//        ]
//        Explanation:
//        "Act zoo" < "act car", So the output is as above.
//        Example2
//
//        Input:
//        [
//        "zo4 4 7",
//        "a100 Actzoo",
//        "a100 Act zoo",
//        "Tac Bctzoo",
//        "Tab Bctzoo",
//        "g9 act car"
//        ]
//        Output:
//        [
//        "a100 Act zoo",
//        "a100 Actzoo",
//        "Tab Bctzoo",
//        "Tac Bctzoo",
//        "g9 act car",
//        "zo4 4 7"
//        ]
//        Explanation:
//        Because "Bctzoo" == "Bctzoo", the comparison "Tab" and "Tac" have "Tab" < Tac ", so" Tab Bctzoo "< Tac Bctzoo".
//        Because ' '<'z', so "A100 Act zoo" < A100 Actzoo".
//        Notice
//        The total number of logs entered was n, and n < = 10000.
//
//        The length of each line is mi, and mi < = 100.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogSorting {

    public class Solution {
        /**
         * @param logs: the logs
         * @return: the log after sorting
         */
        public String[] logSort(String[] logs) {
            // Write your code here
            if (logs == null) {
                return null;
            }

            List<String> sgeg = new ArrayList<>();
            List<String> sgeg1 = new ArrayList<>();
            sgeg.addAll(sgeg1);

            String[] ans = new String[logs.length];
            List<String> list = new ArrayList<>();
            int cur = logs.length - 1;
            for (int i = logs.length - 1; i >=0; i--) {
                String str = logs[i];
                int index = str.indexOf(" ");
                String body = str.substring(index + 1);
                if (body.length() > 0 && body.charAt(0) >= '0' && body.charAt(0) <= '9') {
                    ans[cur--] = str;
                } else {
                    list.add(new String(str));
                }
            }

            Collections.sort(list, new Comparator<String>() {
                public int compare(String a, String b) {
                    int index1 = a.indexOf(" ");
                    int index2 = b.indexOf(" ");
                    String head1 = a.substring(0, index1);
                    String head2 = b.substring(0, index2);

                    String body1 = a.substring(index1 + 1);
                    String body2 = b.substring(index2 + 1);

                    if (body1.equals(body2)) {
                        return head1.compareTo(head2);
                    } else {
                        return body1.compareTo(body2);
                    }
                }
            });

            cur = 0;
            for (String str: list) {
                ans[cur++] = str;
            }

            return ans;
        }


    }
}
