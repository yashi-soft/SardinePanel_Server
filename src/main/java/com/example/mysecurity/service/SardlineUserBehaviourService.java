package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineUserBehaviour;

import java.util.Date;
import java.util.List;

/**
 * (SardlineUserBehaviour)表服务接口
 *
 * @author makejava
 * @since 2020-11-11 11:09:56
 */
public interface SardlineUserBehaviourService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    List<SardlineUserBehaviour> queryById(String userId, String startTime);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUserBehaviour> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 实例对象
     */
    boolean insert(SardlineUserBehaviour sardlineUserBehaviour);

    /**
     * 通过用户名字模糊查询
     * */
    List<SardlineUserBehaviour> queryByName(String name);

    /**
     * 修改数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 实例对象
     */
//    boolean update(SardlineUserBehaviour sardlineUserBehaviour);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(String userId);

}