package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SardlineRoleOrg)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public class SardlineRoleOrg implements Serializable {
    private static final long serialVersionUID = 120890950979321413L;
    /**
    * 主键
    */
    private String id;
    /**
    * 角色id
    */
    private String roleId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}