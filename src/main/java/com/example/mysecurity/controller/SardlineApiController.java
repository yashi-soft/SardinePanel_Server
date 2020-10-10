package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.service.SardlineApiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineApi)表控制层
 *
 * @author makejava
 * @since 2020-10-10 10:40:56
 */
@RestController
@RequestMapping("sardlineApi")
public class SardlineApiController {
    /**
     * 服务对象
     */
    @Resource
    private SardlineApiService sardlineApiService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SardlineApi selectOne(String id) {
        return this.sardlineApiService.queryById(id);
    }

}