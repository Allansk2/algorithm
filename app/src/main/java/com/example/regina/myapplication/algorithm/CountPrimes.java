package com.example.regina.myapplication.algorithm;



//1324. Count Primes
//        中文English
//        Count the number of prime numbers less than a non-negative number, n.
//
//        Example
//        Example 1：
//
//        Input: n = 2
//        Output: 0
//        Example 2：
//
//        Input: n = 4
//        Output: 2
//        Explanation：2, 3 are prime number

public class CountPrimes {
    public class Solution {
        /**
         * @param n: a integer
         * @return: return a integer
         */
        public int countPrimes(int n) {
            // write your code here
            if (n <= 1) {
                return 0;
            }

            int res = 0;
            boolean[] notPrime = new boolean[n];

            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    res++;

                    for (int j = 2; i * j < n; j++) {
                        notPrime[i * j] = true;
                    }
                }
            }

            return res;
        }
    }

}
