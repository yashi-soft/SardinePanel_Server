package com.example.mysecurity.entity.req;

import com.example.mysecurity.entity.SardlineUser;
import lombok.Data;

@Data
public class SardineUserReq extends SardlineUser {


    private String newPassword;

}
