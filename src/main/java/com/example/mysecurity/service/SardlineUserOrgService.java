package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineUserOrg;
import java.util.List;

/**
 * (SardlineUserOrg)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public interface SardlineUserOrgService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineUserOrg queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUserOrg> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 实例对象
     */
    SardlineUserOrg insert(SardlineUserOrg sardlineUserOrg);

    /**
     * 修改数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 实例对象
     */
    SardlineUserOrg update(SardlineUserOrg sardlineUserOrg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}