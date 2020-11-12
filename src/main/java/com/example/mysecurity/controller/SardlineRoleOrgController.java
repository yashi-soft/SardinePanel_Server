package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineRoleOrg;
import com.example.mysecurity.service.SardlineRoleOrgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineRoleOrg)表控制层
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineRoleOrg")
public class SardlineRoleOrgController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineRoleOrgService sardlineRoleOrgService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineRoleOrg selectOne(String id) {
        return this.sardlineRoleOrgService.queryById(id);
    }

}