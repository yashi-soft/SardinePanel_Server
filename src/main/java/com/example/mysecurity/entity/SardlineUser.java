package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (SardlineUser)实体类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@TableName("sardline_user")
public class SardlineUser implements Serializable {
    private static final long serialVersionUID = -73374561944113245L;
    /**
    * 用户id
    */
    @TableId(type = IdType.UUID)
    private String userId;
    /**
    * 用户姓名
    */
    private String userName;
    /**
    * 昵称
    */
    private String nickName;
    /**
    * 密码
    */
    private String passWord;
    /**
    * 描述
    */
    private String description;
    /**
    * 状态
    */
    private Integer state;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}