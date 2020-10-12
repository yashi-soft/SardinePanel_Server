package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.mapper.SardlineRoleDao;
import com.example.mysecurity.service.SardlineRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineRole)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineRoleService")
public class SardlineRoleServiceImpl implements SardlineRoleService {
    @Resource
    private SardlineRoleDao sardlineRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public SardlineRole queryById(String roleId) {
        return this.sardlineRoleDao.queryById(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineRole> queryAllByLimit(int offset, int limit) {
        return this.sardlineRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineRole 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRole insert(SardlineRole sardlineRole) {
        this.sardlineRoleDao.insert(sardlineRole);
        return sardlineRole;
    }

    /**
     * 修改数据
     *
     * @param sardlineRole 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRole update(SardlineRole sardlineRole) {
        this.sardlineRoleDao.update(sardlineRole);
        return this.queryById(sardlineRole.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String roleId) {
        return this.sardlineRoleDao.deleteById(roleId) > 0;
    }
}