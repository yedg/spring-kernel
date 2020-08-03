package com.zwy.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyCacheManager<T> {
    private Map<String,T> cache=new ConcurrentHashMap<>(16);


    public T getValue(String name) {
        System.out.println("get from cache");
        return cache.get(name);
    }

    public void addOrUpdateCache(String name, T result) {
        System.out.println("addOrUpdateCache");
        cache.put(name,result);
    }
}
