package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (SardlineRoleOrg)实体类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@TableName("sardline_role_org")
public class SardlineRoleOrg implements Serializable {
    private static final long serialVersionUID = 120890950979321413L;
    /**
    * 主键
    */
    @TableId(type = IdType.UUID)
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