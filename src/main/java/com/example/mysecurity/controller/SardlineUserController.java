package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.SardlineUserRole;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.service.SardlineUserRoleService;
import com.example.mysecurity.service.SardlineUserService;
import com.example.mysecurity.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SardlineUserRoleService sardlineUserRoleService;



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
    public Result<Boolean> cancel(@RequestBody(required = false) SardlineUser user) {
        user.setState(0);
        return Result.success(sardlineUserService.update(user) == null ? false : true);
    }


    /**
     * 用户修改
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody(required = false) SardlineUser user) {
        user.setState(0);
        return Result.success(sardlineUserService.update(user) == null ? false : true);
    }


    @PostMapping("queryUser")
    public Result<UserVo> queryUserForLogin(String username) {

        if (sardlineUserService.queryUserForLogin(username) != null) {
            return Result.success(sardlineUserService.queryUserForLogin(username));
        } else {
            return Result.noData();
        }


    }

    /**
     * 用户列表
     * */
    @PostMapping("list")
    public Result<PageInfo<SardlineUser>> UserList(@Validated PageParm pageParm, @Validated SardlineUser sardlineUser) {

        return Result.success(this.sardlineUserService.queryAll(pageParm,sardlineUser));

    }

    /**
     * 删除用户
     */
    @PostMapping("deleteUser")
    public Result<Boolean> deleteUser(String userId) {

        return Result.success(this.sardlineUserService.delete(userId));
    }


    /**
     * 分配角色
     */
    @PostMapping("setRoles")
    public Result<Boolean> queryUserForLogin(@RequestParam("userId") String userId, @RequestParam("roleIds") String roleIds) {

        return Result.success(this.sardlineUserRoleService.setRoles(userId,roleIds));


    }

}