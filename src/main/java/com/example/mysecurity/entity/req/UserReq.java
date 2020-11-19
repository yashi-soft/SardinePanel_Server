package com.example.mysecurity.entity.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserReq {
    /**
     * 用户姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passWord;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String mailBox;
    /**
     * 描述
     */
    @NotBlank(message = "描述不能为空")
    private String description;
    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String state;
}
