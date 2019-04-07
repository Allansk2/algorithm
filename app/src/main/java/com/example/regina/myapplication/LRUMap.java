package com.example.regina.myapplication;

import java.util.LinkedHashMap;

/**
 * Created by Allan Zhu on 2019-03-18.
 */
public class LRUMap <K, V> extends LinkedHashMap<K, V> {
    private final int mCacheSize;

    public LRUMap(int cacheSize) {
        super(cacheSize, 0.75f, true);
        mCacheSize = cacheSize;
    }

    @Override
    protected final boolean removeEldestEntry(final Entry<K, V> eldest) {
        return size() > mCacheSize;
    }
}
