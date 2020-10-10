package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.service.SardlineMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

}