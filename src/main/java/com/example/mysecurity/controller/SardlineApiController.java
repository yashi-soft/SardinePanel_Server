package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.service.SardlineApiService;
import com.example.mysecurity.vo.MenuVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SardlineApi)表控制层
 *
 * @author fjx
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
//

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result<SardlineApi> selectOne(String id) {
        return Result.success(this.sardlineApiService.queryById(id));
    }
//
//    @PostMapping("list")
//    public Result<MenuVo> getMenuList(String roleId) {
//
//
//        return Result.success(this.sardlineApiService.getMenuVo(roleId));
//    }


    /**
     * 新增api
     */
    @PostMapping("addApi")
    public Result<Boolean> addMenu(SardlineApi api) {

        return Result.success(this.sardlineApiService.add(api) != null ? true : false);
    }

    /**
     * 修改菜单
     */
    @PostMapping("updateApi")
    public Result<Boolean> updateMenu(SardlineApi api) {

        return Result.success(this.sardlineApiService.update(api) != null ? true : false);
    }


    /**
     * 删除菜单
     */
    @PostMapping("deleteApi")
    public Result<Boolean> deleteMenu(String apiId) {

        return Result.success(this.sardlineApiService.deleteById(apiId));
    }


}