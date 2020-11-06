package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SarlineToken)实体类
 *
 * @author makejava
 * @since 2020-11-06 14:25:45
 */
public class SarlineToken implements Serializable {
    private static final long serialVersionUID = 230404923026575857L;
    
    private String id;
    
    private String name;
    
    private String token;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}