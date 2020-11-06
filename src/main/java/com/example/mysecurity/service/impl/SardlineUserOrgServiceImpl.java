package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.entity.SardlineUserOrg;
import com.example.mysecurity.entity.req.SardineUserReq;
import com.example.mysecurity.mapper.SardlineUserOrgDao;
import com.example.mysecurity.service.SardlineUserOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineUserOrg)表服务实现类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineUserOrgService")
public class SardlineUserOrgServiceImpl implements SardlineUserOrgService {
    @Resource
    private SardlineUserOrgDao sardlineUserOrgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SardlineUserOrg queryById(String id) {
        return this.sardlineUserOrgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineUserOrg> queryAllByLimit(int offset, int limit) {
        return this.sardlineUserOrgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUserOrg insert(SardlineUserOrg sardlineUserOrg) {
        this.sardlineUserOrgDao.insert(sardlineUserOrg);
        return sardlineUserOrg;
    }

    /**
     * 修改数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUserOrg update(SardlineUserOrg sardlineUserOrg) {
        this.sardlineUserOrgDao.update(sardlineUserOrg);
        return this.queryById(sardlineUserOrg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sardlineUserOrgDao.deleteById(id) > 0;
    }

    @Override
    public List<SardlineOrganization> queryByUserId(String userId) {
        return this.sardlineUserOrgDao.queryByUserId(userId);
    }

    @Override
    public Boolean setOrgs(String userId, String orgIds) {
        this.sardlineUserOrgDao.deleteByUserId(userId);
        String[] split = orgIds.split(",");
        SardlineUserOrg sardlineUserOrg = new SardlineUserOrg();
        sardlineUserOrg.setUserId(userId);
        for(int i = 0; i < split.length; i++){
            sardlineUserOrg.setOrgId(split[i]);
            this.insert(sardlineUserOrg);
        }
        return true;
    }

    @Override
    public Object updatePassword(SardineUserReq req) {



        return null;
    }
}