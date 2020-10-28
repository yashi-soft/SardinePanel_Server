package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineRoleMenu;
import com.example.mysecurity.service.SardlineRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineRoleMenu")
public class SardlineRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineRoleMenuService sardlineRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineRoleMenu selectOne(String id) {
        return this.sardlineRoleMenuService.queryById(id);
    }

}