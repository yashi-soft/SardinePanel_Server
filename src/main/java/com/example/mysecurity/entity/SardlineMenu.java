package com.example.mysecurity.entity;

import java.io.Serializable;

/**
 * (SardlineMenu)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public class SardlineMenu implements Serializable {
    private static final long serialVersionUID = -70371943597984101L;
    /**
    * 菜单id
    */
    private String menuId;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 菜单路径
    */
    private String menuPath;
    /**
    * 上级id
    */
    private String pid;
    /**
    * 排序
    */
    private String sort;
    /**
    * 描述
    */
    private String description;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}