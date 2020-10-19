package com.example.mysecurity.service;

import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.entity.so.UserListSo;
import com.example.mysecurity.vo.UserVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SardlineUser)表服务接口
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
public interface SardlineUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SardlineUser queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    SardlineUser insert(SardlineUser sardlineUser);

    /**
     * 修改数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    SardlineUser update(SardlineUser sardlineUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    SardlineUser queryByName(String name);

    Result register(SardlineUser user);

    boolean checkLogin(String username, String password);

    UserVo queryUserForLogin(String username);

    PageInfo<UserListSo> queryAll(PageParm pageParm, SardlineUser sardlineUser);

    Boolean delete(String userId);
}