package com.example.mysecurity.controller;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.service.SardlineOrganizationService;
import com.example.mysecurity.vo.OrgVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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


    /**
     * 查询可分配角色
     */
    @PostMapping("orgList")
    public Result<List<SardlineOrganization>> organizationList() {
        return Result.success(this.sardlineOrganizationService.queryAll());
    }


    @GetMapping("orgTree")
    public Result<OrgVo> orgTree(String orgName) {
        OrgVo orgVo = sardlineOrganizationService.queryByName(orgName);

        return Result.success(orgVo);
    }

    @PostMapping("addOrg")
    public Result<Boolean> addOrg(SardlineOrganization org) {
        return Result.success(sardlineOrganizationService.insert(org) != null ? true : false);
    }


    @PostMapping("updateOrg")
    public Result<Boolean> updateOrg(SardlineOrganization org){
       return  Result.success(sardlineOrganizationService.update(org)!=null?true:false);
    }

    @PostMapping("delete")
    public Result<Boolean> deleteOrg(String orgId){
        return  Result.success(sardlineOrganizationService.delete(orgId));
    }











}