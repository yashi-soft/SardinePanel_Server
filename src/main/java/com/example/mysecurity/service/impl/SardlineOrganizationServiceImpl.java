package com.example.mysecurity.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.mapper.SardlineOrganizationDao;
import com.example.mysecurity.mapper.SardlineRoleOrgDao;
import com.example.mysecurity.mapper.SardlineUserOrgDao;
import com.example.mysecurity.service.SardlineOrganizationService;
import com.example.mysecurity.vo.OrgVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private SardlineUserOrgDao sardlineUserOrgDao;

    @Resource
    private SardlineRoleOrgDao sardlineRoleOrgDao;

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
     * @param limit  查询条数
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
        sardlineOrganization.setCreateTime(DateUtil.date());
        sardlineOrganization.setUpdateTime(DateUtil.date());

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
        sardlineOrganization.setUpdateTime(DateUtil.date());
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

    @Override
    public List<SardlineOrganization> queryAll() {
        return sardlineOrganizationDao.queryAll(new SardlineOrganization());
    }

    @Override
    public OrgVo queryByName(String orgName) {

        List<OrgVo> orgs = sardlineOrganizationDao.queryByName(orgName);
        Map<String, OrgVo> allOrg = new HashMap<>();
        for (OrgVo vo : orgs) {
            allOrg.put(vo.getOrgId(), vo);
        }

        for (OrgVo vo : orgs) {

            String pid = vo.getPid();
            if (pid != null) {
                OrgVo orgVo = allOrg.get(pid);
                orgVo.getChildren().add(allOrg.get(vo.getOrgId()));
            }
        }

        return allOrg.get("-1");
    }

    @Override
    @Transactional
    public Boolean delete(String orgId) {
        Boolean flag1 = sardlineOrganizationDao.deleteById(orgId) > 0;
        Boolean flag2 = sardlineUserOrgDao.deleteByOrgId(orgId);
        Boolean flag3 = sardlineRoleOrgDao.deleteByOrgId(orgId);
        return flag1 && flag2 && flag3;
    }
}