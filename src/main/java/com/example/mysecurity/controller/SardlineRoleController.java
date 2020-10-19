package com.example.mysecurity.controller;

import com.example.mysecurity.common.PageResult;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.entity.req.SardlineRoleReq;
import com.example.mysecurity.service.SardlineRoleService;
import com.example.mysecurity.vo.MenuVo;
import com.example.mysecurity.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineRole)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineRole")
public class SardlineRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineRoleService sardlineRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineRole selectOne(String id) {
        return this.sardlineRoleService.queryById(id);
    }


    /**
     * 新建角色
     *
     * @param sardlineRole
     * @return
     */
    @PostMapping("addRole")
    public Result<Boolean> add(SardlineRole sardlineRole) {


        return Result.success(this.sardlineRoleService.add(sardlineRole) != null ? true : false);

    }


    /**
     * 角色列表
     *
     * @return
     */
    @PostMapping("list")
    public Result<List<SardlineRole>> list() {
        return Result.success(this.sardlineRoleService.queryAll());

    }

    /**
     * 角色列表
     *
     * @return
     */
    @GetMapping("listForPage")
    public Result<PageInfo<SardlineRole>> listForPage(@Validated PageParm pageParm, @Validated SardlineRole req) {
        return Result.success(this.sardlineRoleService.queryForPage(pageParm, req));

    }

    /**
     * 查询所有角色和api列表
     */
    @PostMapping("apiAndMenulist")
    public Result<MenuVo> getAllMenuAndApi(String roleId) {
        return Result.success(this.sardlineRoleService.getAllMenuAndApi(roleId));
    }


//    /**
//     * 分配权限
//     */
//    @PostMapping("distribution")
//    public Result<Boolean> distribution(){
//
//
//
//    }


    /**
     * 查询可分配角色
     */
    @PostMapping("roleList")
    public Result<List<SardlineRole>> roleList() {
        return Result.success(this.sardlineRoleService.queryAll());

    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> delete(String roleId) {
        return Result.success(sardlineRoleService.delete(roleId));
    }







}