package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.dao.SardlineMenuDao;
import com.example.mysecurity.service.SardlineMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineMenuService")
public class SardlineMenuServiceImpl implements SardlineMenuService {
    @Resource
    private SardlineMenuDao sardlineMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @Override
    public SardlineMenu queryById(String menuId) {
        return this.sardlineMenuDao.queryById(menuId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineMenu> queryAllByLimit(int offset, int limit) {
        return this.sardlineMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineMenu insert(SardlineMenu sardlineMenu) {
        this.sardlineMenuDao.insert(sardlineMenu);
        return sardlineMenu;
    }

    /**
     * 修改数据
     *
     * @param sardlineMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineMenu update(SardlineMenu sardlineMenu) {
        this.sardlineMenuDao.update(sardlineMenu);
        return this.queryById(sardlineMenu.getMenuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String menuId) {
        return this.sardlineMenuDao.deleteById(menuId) > 0;
    }
}