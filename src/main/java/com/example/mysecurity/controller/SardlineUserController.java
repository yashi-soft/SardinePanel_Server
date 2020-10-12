package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.service.SardlineUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineUser)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("user")
public class SardlineUserController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineUserService sardlineUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineUser selectOne(String id) {
        return this.sardlineUserService.queryById(id);
    }


    @PostMapping("register")
    public Result register(@RequestBody(required = false) SardlineUser user) {
        return sardlineUserService.register(user);


    }


}