package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.service.SardlineOrganizationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineOrganization)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@RestController
@RequestMapping("sardlineOrganization")
public class SardlineOrganizationController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineOrganizationService sardlineOrganizationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineOrganization selectOne(String id) {
        return this.sardlineOrganizationService.queryById(id);
    }

}