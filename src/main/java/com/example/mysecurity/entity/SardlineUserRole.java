package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SardlineUserRole)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public class SardlineUserRole implements Serializable {
    private static final long serialVersionUID = 731738669911360943L;
    /**
    * 主键
    */
    private String id;
    /**
    * 角色id
    */
    private String roleId;
    /**
    * 用户id
    */
    private String userId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}