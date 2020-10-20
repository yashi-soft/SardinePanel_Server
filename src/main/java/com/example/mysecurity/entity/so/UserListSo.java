package com.example.mysecurity.entity.so;

import lombok.Data;

import java.util.Date;

@Data
public class UserListSo {
    private String id;
    /**
     * 用户姓名
     */
    private String userName;

    private String nickName;
    /**
     * 描述
     */
    private String description;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mailBox;

    private Integer state;

    private Date registerTime;

    private Date loginTime;

    private String roleIds;

    private String roleList;

    private String organizationIds;

    private String organizationList;

}
