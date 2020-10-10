package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineRoleOrg;
import com.example.mysecurity.dao.SardlineRoleOrgDao;
import com.example.mysecurity.service.SardlineRoleOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineRoleOrg)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineRoleOrgService")
public class SardlineRoleOrgServiceImpl implements SardlineRoleOrgService {
    @Resource
    private SardlineRoleOrgDao sardlineRoleOrgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SardlineRoleOrg queryById(String id) {
        return this.sardlineRoleOrgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineRoleOrg> queryAllByLimit(int offset, int limit) {
        return this.sardlineRoleOrgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineRoleOrg 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleOrg insert(SardlineRoleOrg sardlineRoleOrg) {
        this.sardlineRoleOrgDao.insert(sardlineRoleOrg);
        return sardlineRoleOrg;
    }

    /**
     * 修改数据
     *
     * @param sardlineRoleOrg 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleOrg update(SardlineRoleOrg sardlineRoleOrg) {
        this.sardlineRoleOrgDao.update(sardlineRoleOrg);
        return this.queryById(sardlineRoleOrg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sardlineRoleOrgDao.deleteById(id) > 0;
    }
}