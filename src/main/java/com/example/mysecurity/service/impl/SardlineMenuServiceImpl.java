package com.example.mysecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.entity.SardlineRoleMenu;
import com.example.mysecurity.mapper.SardlineApiDao;
import com.example.mysecurity.mapper.SardlineMenuDao;
import com.example.mysecurity.mapper.SardlineRoleMenuDao;
import com.example.mysecurity.service.SardlineMenuService;
import com.example.mysecurity.service.SardlineRoleMenuService;
import com.example.mysecurity.vo.MenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private SardlineRoleMenuDao sardlineRoleMenuDao;

    @Resource
    private SardlineApiDao sardlineApiDao;


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
        this.sardlineMenuDao.updateByMenuId(sardlineMenu);
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
            String pid = menu.getPid();
            if (pid != null) {
                MenuVo menu1 = allMenu.get(pid);
                if (menu1 != null) {
                    menu1.getChildren().add(allMenu.get(menu.getMenuId()));
                }

            }
        }

        return allMenu.get(rootid);
    }

    @Override
    public MenuVo queryAllMenu() {
        List<SardlineMenu> menus = this.sardlineMenuDao.queryAll(new SardlineMenu());
        Map<String, MenuVo> allMenu = new HashMap();
        for (SardlineMenu menu : menus) {
            allMenu.put(menu.getMenuId(), BeanUtil.toBean(menu, MenuVo.class));
        }
        String rootid = "-1";

        for (SardlineMenu menu : menus) {
            String pid = menu.getPid();
            if (pid != null) {
                MenuVo menu1 = allMenu.get(pid);
                if (menu1 != null) {
                    menu1.getChildren().add(allMenu.get(menu.getMenuId()));
                }

            }
        }

        return allMenu.get(rootid);
    }

    @Override
    @Transactional
    public Boolean addMenu(SardlineMenu menu) {

        int insert = this.sardlineMenuDao.insert(menu);

        //赋值给admin

        SardlineRoleMenu rm = new SardlineRoleMenu();
        rm.setMenuId(menu.getMenuId());
        rm.setRoleId("1");
        int insert1 = sardlineRoleMenuDao.insert(rm);
        return insert > 0 && insert1 > 0;
    }

    @Override
    public Boolean delete(String menuId) {
        //删除菜单信息
        int i = sardlineMenuDao.deleteById(menuId);
        int roleCount = sardlineRoleMenuDao.queryByMenuId(menuId);
        //删除角色关联菜单信息
        int k = sardlineRoleMenuDao.deleteByMenuId(menuId);

        //删除菜单关联api信息
        Integer apiCount = sardlineApiDao.queryCountByMenuId(menuId);
        Integer a = sardlineApiDao.deletebyMenuId(menuId);

        return i > 0 && k == roleCount && a == apiCount;
    }
}