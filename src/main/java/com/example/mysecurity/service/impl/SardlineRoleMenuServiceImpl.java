package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.entity.SardlineRoleMenu;
import com.example.mysecurity.mapper.SardlineRoleMenuDao;
import com.example.mysecurity.service.SardlineRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineRoleMenuService")
public class SardlineRoleMenuServiceImpl implements SardlineRoleMenuService {
    @Resource
    private SardlineRoleMenuDao sardlineRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SardlineRoleMenu queryById(String id) {
        return this.sardlineRoleMenuDao.queryById(id);
    }

    @Override
    public List<SardlineMenu> queryByRoleId(String roleId) {
        return this.sardlineRoleMenuDao.queryByRoleId(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.sardlineRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleMenu insert(SardlineRoleMenu sardlineRoleMenu) {
        this.sardlineRoleMenuDao.insert(sardlineRoleMenu);
        return sardlineRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param sardlineRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineRoleMenu update(SardlineRoleMenu sardlineRoleMenu) {
        this.sardlineRoleMenuDao.update(sardlineRoleMenu);
        return this.queryById(sardlineRoleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sardlineRoleMenuDao.deleteById(id) > 0;
    }
}