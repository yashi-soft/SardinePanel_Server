package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.entity.req.SardlineRoleReq;
import com.example.mysecurity.vo.MenuVo;
import com.example.mysecurity.vo.RoleVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SardlineRole)表服务接口
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
public interface SardlineRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SardlineRole queryById(String roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SardlineRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineRole 实例对象
     * @return 实例对象
     */
    SardlineRole insert(SardlineRole sardlineRole);

    /**
     * 修改数据
     *
     * @param sardlineRole 实例对象
     * @return 实例对象
     */
    SardlineRole update(SardlineRole sardlineRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(String roleId);

    MenuVo getAllMenuAndApi(String roleId);

    List<SardlineRole> queryAll();

    Boolean add(SardlineRole sardlineRole);

    Boolean addRole(SardlineRoleReq sardlineRole);

    PageInfo<RoleVo> queryForPage(PageParm pageParm, SardlineRole req);

    Boolean delete(String roleId);

    Boolean updateRole(SardlineRoleReq req);
}