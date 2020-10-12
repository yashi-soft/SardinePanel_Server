package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUserRole;

import java.util.List;

/**
 * (SardlineUserRole)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public interface SardlineUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineUserRole queryById(String id);

    List<SardlineUserRole> queryByUserId(String userId);







    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SardlineUserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineUserRole 实例对象
     * @return 实例对象
     */
    SardlineUserRole insert(SardlineUserRole sardlineUserRole);

    /**
     * 修改数据
     *
     * @param sardlineUserRole 实例对象
     * @return 实例对象
     */
    SardlineUserRole update(SardlineUserRole sardlineUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<SardlineRole> queryRolesByUserId(String userId);
}