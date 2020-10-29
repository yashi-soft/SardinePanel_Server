package com.example.mysecurity.service;

;


import com.example.mysecurity.entity.SardlineRoleApi;

import java.util.List;

/**
 * (SardlineRoleApi)表服务接口
 *
 * @author fjx
 * @since 2020-10-16 10:03:36
 */
public interface SardlineRoleApiService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineRoleApi queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineRoleApi> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 实例对象
     */
    SardlineRoleApi insert(SardlineRoleApi sardlineRoleApi);

    /**
     * 修改数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 实例对象
     */
    SardlineRoleApi update(SardlineRoleApi sardlineRoleApi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}