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
    public MenuVo getMenuList(String roleId) {
        return this.sardlineMenuService.getMenuVo(roleId);
    }


    /**
     * 新增菜单
     */
    @PostMapping("addMenu")
    public Boolean addMenu(SardlineMenu menu) {

        return this.sardlineMenuService.insert(menu) != null ? true : false;


    }

    /**
     * 修改菜单
     */
    @PostMapping("updateMenu")
    public Boolean updateMenu(SardlineMenu menu) {

        return this.sardlineMenuService.update(menu) != null ? true : false;
    }


    /**
     * 删除菜单
     */
    @PostMapping("deleteMenu")
    public Boolean deleteMenu(String menuId) {

        return this.sardlineMenuService.deleteById(menuId);
    }

}