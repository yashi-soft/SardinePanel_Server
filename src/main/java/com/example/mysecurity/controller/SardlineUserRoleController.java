package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineUserRole;
import com.example.mysecurity.service.SardlineUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineUserRole)表控制层
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineUserRole")
public class SardlineUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineUserRoleService sardlineUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineUserRole selectOne(String id) {
        return this.sardlineUserRoleService.queryById(id);
    }

}