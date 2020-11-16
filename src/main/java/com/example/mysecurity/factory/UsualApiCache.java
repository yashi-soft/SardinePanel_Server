package com.example.mysecurity.factory;

import com.example.mysecurity.annotation.UsualApi;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import sun.reflect.Reflection;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class UsualApiCache {

    private static UsualApiCache usualApiCache = new UsualApiCache();

    private static UsualApiCache getInstance() {
        return usualApiCache;
    }

    private static Map map = new HashMap();

    static {
        Reflections reflections = new Reflections("com.example.mysecurity.controller");
        Set<Method> methodSet = reflections.getMethodsMatchParams(UsualApi.class);
        for (Method method : methodSet) {
            UsualApi ua = method.getAnnotation(UsualApi.class);
            map.put(ua.name(), ua.type());
        }

    }

    public static Map getMap() {
        return usualApiCache.map;
    }

}
