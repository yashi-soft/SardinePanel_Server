package com.example.mysecurity.controller;


import com.example.mysecurity.entity.SardlineRoleApi;
import com.example.mysecurity.service.SardlineRoleApiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineRoleApi)表控制层
 *
 * @author fjx
 * @since 2020-10-16 10:03:36
 */
@RestController
@RequestMapping("sardlineRoleApi")
public class SardlineRoleApiController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineRoleApiService sardlineRoleApiService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineRoleApi selectOne(String id) {
        return this.sardlineRoleApiService.queryById(id);
    }

}