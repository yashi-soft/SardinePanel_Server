package com.example.mysecurity.service.impl;



import com.example.mysecurity.entity.SardlineRoleApi;
import com.example.mysecurity.mapper.SardlineRoleApiDao;
import com.example.mysecurity.service.SardlineRoleApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineRoleApi)表服务实现类
 *
 * @author makejava
 * @since 2020-10-16 10:03:36
 */
@Service("sardlineRoleApiService")
public class SardlineRoleApiServiceImpl implements SardlineRoleApiService {
    @Resource
    private SardlineRoleApiDao sardlineRoleApiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SardlineRoleApi queryById(String id) {
        return this.sardlineRoleApiDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineRoleApi> queryAllByLimit(int offset, int limit) {
        return this.sardlineRoleApiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleApi insert(SardlineRoleApi sardlineRoleApi) {
        this.sardlineRoleApiDao.insert(sardlineRoleApi);
        return sardlineRoleApi;
    }

    /**
     * 修改数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleApi update(SardlineRoleApi sardlineRoleApi) {
        this.sardlineRoleApiDao.update(sardlineRoleApi);
        return this.queryById(sardlineRoleApi.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sardlineRoleApiDao.deleteById(id) > 0;
    }
}