package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.service.SardlineMenuService;
import com.example.mysecurity.vo.MenuVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineMenu)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineMenu")
public class SardlineMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineMenuService sardlineMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineMenu selectOne(String id) {
        return this.sardlineMenuService.queryById(id);
    }


    @PostMapping("list")
    public Result<MenuVo> getMenuList(String roleId) {


        return Result.success(this.sardlineMenuService.getMenuVo(roleId));
    }


    /**
     * 新增菜单
     */
    @PostMapping("addMenu")
    public Result<Boolean> addMenu(SardlineMenu menu) {

        return Result.success(this.sardlineMenuService.addMenu(menu) != null ? true : false);
    }

    /**
     * 修改菜单
     */
    @PostMapping("updateMenu")
    public Result<Boolean> updateMenu(SardlineMenu menu) {

        return Result.success(this.sardlineMenuService.update(menu) != null ? true : false);
    }


    /**
     * 删除菜单
     */
    @PostMapping("deleteMenu")
    public Result<Boolean> deleteMenu(String menuId) {

        return Result.success(this.sardlineMenuService.delete(menuId));
    }

    /**
     * 查询菜单
     */
    @PostMapping("queryAllMenu")
    public Result<MenuVo> queryAllMenu() {

        return Result.success(this.sardlineMenuService.queryAllMenu());
    }


}