package com.example.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sardline_role_api")
@Data
public class SardlineRoleApi {

    @TableId(type = IdType.UUID)
    private String id;

    private String roleId;

    private String apiId;

}
