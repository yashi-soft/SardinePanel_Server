package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (SardlineUserRole)实体类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@TableName("sardline_user_role")
public class SardlineUserRole implements Serializable {
    private static final long serialVersionUID = 731738669911360943L;
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