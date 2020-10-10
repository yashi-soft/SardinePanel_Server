package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SardlineUserOrg)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public class SardlineUserOrg implements Serializable {
    private static final long serialVersionUID = 329036551844949925L;
    /**
    * 主键
    */
    private String id;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 组织id
    */
    private String orgId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}