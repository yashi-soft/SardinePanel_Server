package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.dao.SardlineUserDao;
import com.example.mysecurity.service.SardlineUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineUser)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineUserService")
public class SardlineUserServiceImpl implements SardlineUserService {
    @Resource
    private SardlineUserDao sardlineUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SardlineUser queryById(String userId) {
        return this.sardlineUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineUser> queryAllByLimit(int offset, int limit) {
        return this.sardlineUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUser insert(SardlineUser sardlineUser) {
        this.sardlineUserDao.insert(sardlineUser);
        return sardlineUser;
    }

    /**
     * 修改数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUser update(SardlineUser sardlineUser) {
        this.sardlineUserDao.update(sardlineUser);
        return this.queryById(sardlineUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.sardlineUserDao.deleteById(userId) > 0;
    }
}