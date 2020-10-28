package com.example.mysecurity.vo;

import com.example.mysecurity.entity.SardlineUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserVo extends SardlineUser {


    private List<RoleVo> roles = new ArrayList<>();
}
