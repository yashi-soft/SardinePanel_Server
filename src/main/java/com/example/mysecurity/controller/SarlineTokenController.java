package com.example.mysecurity.controller;

import com.example.mysecurity.entity.SarlineToken;
import com.example.mysecurity.service.SarlineTokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SarlineToken)表控制层
 *
 * @author makejava
 * @since 2020-11-06 14:25:46
 */
@RestController
@RequestMapping("sarlineToken")
public class SarlineTokenController {
    /**
     * 服务对象
     */
    @Resource
    private SarlineTokenService sarlineTokenService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SarlineToken selectOne(String id) {
        return this.sarlineTokenService.queryById(id);
    }

}