package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.mapper.SardlineOrganizationDao;
import com.example.mysecurity.service.SardlineOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineOrganization)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineOrganizationService")
public class SardlineOrganizationServiceImpl implements SardlineOrganizationService {
    @Resource
    private SardlineOrganizationDao sardlineOrganizationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    @Override
    public SardlineOrganization queryById(String orgId) {
        return this.sardlineOrganizationDao.queryById(orgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineOrganization> queryAllByLimit(int offset, int limit) {
        return this.sardlineOrganizationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineOrganization 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineOrganization insert(SardlineOrganization sardlineOrganization) {
        this.sardlineOrganizationDao.insert(sardlineOrganization);
        return sardlineOrganization;
    }

    /**
     * 修改数据
     *
     * @param sardlineOrganization 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineOrganization update(SardlineOrganization sardlineOrganization) {
        this.sardlineOrganizationDao.update(sardlineOrganization);
        return this.queryById(sardlineOrganization.getOrgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orgId) {
        return this.sardlineOrganizationDao.deleteById(orgId) > 0;
    }
}