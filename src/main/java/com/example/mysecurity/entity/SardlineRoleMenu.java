package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (SardlineRoleMenu)实体类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@TableName("sardline_role_menu")
public class SardlineRoleMenu implements Serializable {
    private static final long serialVersionUID = -67535347576899737L;

    @TableId(type = IdType.UUID)
    private String id;
    
    private String roleId;
    
    private String menuId;


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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

}