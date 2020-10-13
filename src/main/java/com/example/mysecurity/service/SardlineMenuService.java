package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.vo.MenuVo;

import java.util.List;

/**
 * (SardlineMenu)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public interface SardlineMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SardlineMenu queryById(String menuId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineMenu 实例对象
     * @return 实例对象
     */
    SardlineMenu insert(SardlineMenu sardlineMenu);

    /**
     * 修改数据
     *
     * @param sardlineMenu 实例对象
     * @return 实例对象
     */
    SardlineMenu update(SardlineMenu sardlineMenu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(String menuId);

    MenuVo getMenuVo(String roleId);
}