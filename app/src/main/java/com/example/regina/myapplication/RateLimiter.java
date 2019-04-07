package com.example.regina.myapplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allan Zhu on 2019-03-11.
 */
public class RateLimiter {
    Bucket[] mBuckets = new Bucket[60];

    private RateLimiter() {
        for (int i = 0; i < 60; i++) {
            mBuckets[i] = new Bucket();
        }
    }

    public synchronized boolean isAllow(String clientId) {
        final long secondNow = System.currentTimeMillis() / 1000;
        final int index = (int)(secondNow % 60);
        Bucket bucket = mBuckets[index];
        if (bucket.secondEpod != secondNow) {
            bucket.secondEpod = secondNow;
            bucket.requestCount.clear();
        }

        final Integer count = bucket.requestCount.getOrDefault(clientId, 0);
        if (count > 100) {
            return false;
        }

        bucket.requestCount.put(clientId, count + 1);
        return true;
    }


    private static class Bucket {
        long secondEpod = -1;
        Map<String, Integer> requestCount = new HashMap<>();
    }



}
