package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.service.SardlineUserService;
import com.example.mysecurity.vo.UserVo;
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


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("register")
    public Result register(@RequestBody(required = false) SardlineUser user) {
        return sardlineUserService.register(user);
    }


    /**
     * 注销
     */
    @PostMapping("cancel")
    public Boolean cancel(@RequestBody(required = false) SardlineUser user) {
        user.setState(0);
        return sardlineUserService.update(user) == null ? false : true;
    }


    /**
     * 用户修改
     */
    @PostMapping("update")
    public Boolean update(@RequestBody(required = false) SardlineUser user) {
        user.setState(0);
        return sardlineUserService.update(user) == null ? false : true;
    }

    @PostMapping("queryUser")
    public Result<UserVo> queryUserForLogin(String username) {
        return Result.success(sardlineUserService.queryUserForLogin(username));
    }


}