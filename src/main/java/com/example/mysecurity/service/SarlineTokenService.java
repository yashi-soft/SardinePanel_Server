package com.example.mysecurity.service;

import com.example.mysecurity.entity.SarlineToken;

import java.util.List;

/**
 * (SarlineToken)表服务接口
 *
 * @author makejava
 * @since 2020-11-06 14:25:46
 */
public interface SarlineTokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SarlineToken queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SarlineToken> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sarlineToken 实例对象
     * @return 实例对象
     */
    SarlineToken insert(SarlineToken sarlineToken);

    /**
     * 修改数据
     *
     * @param sarlineToken 实例对象
     * @return 实例对象
     */
    SarlineToken update(SarlineToken sarlineToken);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    SarlineToken queryByName(String name);
}