package com.example.mysecurity.configuration.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * redis缓存，也可用其他缓存代替
 */
public class RedisCache {


    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap();


    public static void setToken(String key, String token) {
        map.put(key, token);
    }

    public static String getToken(String key) {
        return map.get(key);
    }


}
