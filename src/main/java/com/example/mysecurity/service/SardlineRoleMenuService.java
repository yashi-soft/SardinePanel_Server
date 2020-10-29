package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.entity.SardlineRoleMenu;
import java.util.List;

/**
 * (SardlineRoleMenu)表服务接口
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
public interface SardlineRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineRoleMenu queryById(String id);

    List<SardlineMenu> queryByRoleId(String roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineRoleMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineRoleMenu 实例对象
     * @return 实例对象
     */
    SardlineRoleMenu insert(SardlineRoleMenu sardlineRoleMenu);

    /**
     * 修改数据
     *
     * @param sardlineRoleMenu 实例对象
     * @return 实例对象
     */
    SardlineRoleMenu update(SardlineRoleMenu sardlineRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}