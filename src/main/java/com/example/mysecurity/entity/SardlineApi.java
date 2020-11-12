package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (SardlineApi)实体类
 *
 * @author fjx
 * @since 2020-10-10 10:40:55
 */
@TableName("sardline_api")
public class SardlineApi implements Serializable {
    private static final long serialVersionUID = 279938656827938010L;
    /**
    * 主键
    */
    @TableId(type = IdType.UUID)
    private String apiId;
    /**
    * 方法名
    */
    private String apiName;
    /**
    * 方法路径
    */
    private String apiUrl;
    /**
    * 方法名
    */
    private String apiMethod;
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

    private String menuId;

    private String ifUsual;

    public String getIfUsual() {
        return ifUsual;
    }

    public void setIfUsual(String ifUsual) {
        this.ifUsual = ifUsual;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
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