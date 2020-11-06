package com.example.mysecurity.entity.req;

import com.example.mysecurity.entity.SardlineUser;
import lombok.Data;

@Data
public class SardineUserReq extends SardlineUser {

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 确认密码
     */
    private String comfirePassword;

}
