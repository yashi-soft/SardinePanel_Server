package com.example.mysecurity.auth.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 先缓存本地，后期同步到数据库和redis
 */
public class RedisCache {


    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap();


    public static void setToken(String key, String token) {
        map.put(key, token);
    }

    public static String getToken(String key) {
        return map.get(key);
    }

    public static Boolean clearToken(String key, String token) {

        return map.remove(key, token);
    }
}
