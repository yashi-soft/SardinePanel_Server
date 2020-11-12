package com.example.mysecurity.vo;

import com.example.mysecurity.entity.SardlineRole;
import lombok.Data;

import java.util.List;

@Data
public class RoleVo extends SardlineRole {



    private MenuVo menuVo;

    private String apis;

    private String menus;

    private String orgId;

}








