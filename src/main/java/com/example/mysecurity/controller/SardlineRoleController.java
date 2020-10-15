package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.service.SardlineRoleService;
import com.example.mysecurity.vo.MenuVo;
import com.example.mysecurity.vo.RoleVo;
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
    public Boolean add(SardlineRole sardlineRole) {


        return this.sardlineRoleService.add(sardlineRole) != null ? true : false;

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
     * 编辑角色
     */
    @PostMapping("apiAndMenulist")
    public Result<MenuVo> getAllMenuAndApi(String roleId) {
        return Result.success(this.sardlineRoleService.getAllMenuAndApi(roleId));
    }


}