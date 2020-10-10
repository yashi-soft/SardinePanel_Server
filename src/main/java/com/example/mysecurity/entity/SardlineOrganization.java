package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SardlineOrganization)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public class SardlineOrganization implements Serializable {
    private static final long serialVersionUID = 295131874441806056L;
    /**
    * 组织id
    */
    private String orgId;
    /**
    * 组织名称
    */
    private String orgName;
    /**
    * 上级组织id
    */
    private Integer pid;
    /**
    * 描述
    */
    private String description;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}