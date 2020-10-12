package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineUserRole;
import com.example.mysecurity.dao.SardlineUserRoleDao;
import com.example.mysecurity.service.SardlineUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineUserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineUserRoleService")
public class SardlineUserRoleServiceImpl implements SardlineUserRoleService {
    @Resource
    private SardlineUserRoleDao sardlineUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SardlineUserRole queryById(String id) {
        return this.sardlineUserRoleDao.queryById(id);
    }

    @Override
    public List<SardlineUserRole> queryByUserId(String userId) {
        return this.sardlineUserRoleDao.queryByUserId(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineUserRole> queryAllByLimit(int offset, int limit) {
        return this.sardlineUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUserRole insert(SardlineUserRole sardlineUserRole) {
        this.sardlineUserRoleDao.insert(sardlineUserRole);
        return sardlineUserRole;
    }

    /**
     * 修改数据
     *
     * @param sardlineUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUserRole update(SardlineUserRole sardlineUserRole) {
        this.sardlineUserRoleDao.update(sardlineUserRole);
        return this.queryById(sardlineUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sardlineUserRoleDao.deleteById(id) > 0;
    }
}