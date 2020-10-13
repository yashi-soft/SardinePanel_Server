package com.example.mysecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.mapper.SardlineApiDao;
import com.example.mysecurity.mapper.SardlineMenuDao;
import com.example.mysecurity.service.SardlineMenuService;
import com.example.mysecurity.service.SardlineRoleMenuService;
import com.example.mysecurity.vo.MenuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SardlineMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineMenuService")
public class SardlineMenuServiceImpl extends ServiceImpl<SardlineMenuDao, SardlineMenu> implements SardlineMenuService {
    @Resource
    private SardlineMenuDao sardlineMenuDao;


    @Resource
    private SardlineRoleMenuService sardlineRoleMenuService;

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
     * @param limit  查询条数
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
        this.sardlineMenuDao.update(sardlineMenu, null);
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

    @Override
    public MenuVo getMenuVo(String roleId) {
        List<SardlineMenu> menus = sardlineRoleMenuService.queryByRoleId(roleId);
        Map<String, MenuVo> allMenu = new HashMap();
        for (SardlineMenu menu : menus) {
            allMenu.put(menu.getMenuId(), BeanUtil.toBean(menu, MenuVo.class));
        }
        String rootid = "-1";

        for (SardlineMenu menu : menus) {
            MenuVo vo = BeanUtil.toBean(menu, MenuVo.class);
            String pid = vo.getPid();
            if (pid != null) {
                MenuVo menu1 = allMenu.get(pid);
                menu1.getChildren().add(vo);
            }
        }

        return allMenu.get(rootid);
    }
}