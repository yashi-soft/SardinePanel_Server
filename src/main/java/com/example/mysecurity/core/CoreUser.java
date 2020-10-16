package com.example.mysecurity.core;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.SardlineUserRole;
import com.example.mysecurity.service.SardlineUserRoleService;
import com.example.mysecurity.service.SardlineUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoreUser {
    @Autowired
    private SardlineUserService sardlineUserService;
    @Autowired
    private  SardlineUserRoleService sardlineUserRoleService;

    public CoreUser(String userId) {
        this.userId = userId;
    }


    private String userId;
    private List<SardlineUserRole> userRoles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private SardlineUser user;

    public SardlineUser getUser() {
        return sardlineUserService.queryById(this.userId);
    }




    public List<String> getRoles() {
//        return sardlineUserRoleService.queryByUserId(this.userId);
        return null;
    }

//    public List<SardlineRole>



}
