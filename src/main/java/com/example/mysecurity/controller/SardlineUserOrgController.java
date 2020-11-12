package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineUserOrg;
import com.example.mysecurity.service.SardlineUserOrgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineUserOrg)表控制层
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineUserOrg")
public class SardlineUserOrgController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineUserOrgService sardlineUserOrgService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineUserOrg selectOne(String id) {
        return this.sardlineUserOrgService.queryById(id);
    }

}