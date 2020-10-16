package com.example.mysecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineMenu;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.mapper.SardlineApiDao;
import com.example.mysecurity.mapper.SardlineRoleDao;
import com.example.mysecurity.service.SardlineRoleMenuService;
import com.example.mysecurity.service.SardlineRoleService;
import com.example.mysecurity.vo.ApiVo;
import com.example.mysecurity.vo.MenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private SardlineRoleMenuService sardlineRoleMenuService;

    @Resource
    private SardlineApiDao sardlineApiDao;

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
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineRole> queryAllByLimit(int offset, int limit) {
        return this.sardlineRoleDao.queryAllByLimit(offset, limit);
    }

    public List<SardlineRole> queryAll() {
        return this.sardlineRoleDao.queryAll();
    }

    @Override
    @Transactional
    public Boolean add(SardlineRole sardlineRole) {
        //添加角色表
         sardlineRoleDao.insert(sardlineRole);
        //添加角色-菜单表

//        sardlineRoleMenuService.insert()
        //添加角色-api表


        return null;
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
//        this.sardlineRoleDao.update(sardlineRole);
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

    @Override
    public MenuVo getAllMenuAndApi(String roleId) {
        List<SardlineMenu> menus = sardlineRoleMenuService.queryByRoleId(roleId);


        Map<String, MenuVo> allMenu = new HashMap();
        for (SardlineMenu menu : menus) {
            allMenu.put(menu.getMenuId(), BeanUtil.toBean(menu, MenuVo.class));
        }
        String rootid = "-1";

        for (SardlineMenu menu : menus) {
            String pid = menu.getPid();

            List<ApiVo> apis = sardlineApiDao.queryByMenuId(menu.getMenuId());

            MenuVo menu1 = allMenu.get(menu.getMenuId());


//            menu1.setApis(apis);

            if (pid != null) {
                MenuVo menu2 = allMenu.get(pid);
                if (menu2 != null) {
                    menu2.getChildren().add(allMenu.get(menu.getMenuId()));
                }

            }
        }

        return allMenu.get(rootid);
    }
}