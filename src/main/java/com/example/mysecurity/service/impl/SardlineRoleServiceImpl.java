package com.example.mysecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.mysecurity.entity.*;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.entity.req.SardlineRoleReq;
import com.example.mysecurity.mapper.*;
import com.example.mysecurity.service.SardlineRoleMenuService;
import com.example.mysecurity.service.SardlineRoleService;
import com.example.mysecurity.vo.ApiVo;
import com.example.mysecurity.vo.MenuVo;
import com.example.mysecurity.vo.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SardlineRole)表服务实现类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineRoleService")
@Slf4j
public class SardlineRoleServiceImpl implements SardlineRoleService {
    @Resource
    private SardlineRoleDao sardlineRoleDao;

    @Resource
    private SardlineRoleMenuService sardlineRoleMenuService;


    @Resource
    private SardlineApiDao sardlineApiDao;

    @Resource
    private SardlineRoleApiDao sardlineRoleApiDao;

    @Resource
    private SardlineRoleMenuDao sardlineRoleMenuDao;

    @Resource
    private SardlineUserRoleDao sardlineUserRoleDao;
    @Resource
    private SardlineRoleOrgDao sardlineRoleOrgDao;


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
        int insert = sardlineRoleDao.insert(sardlineRole);
        return insert > 0;
    }

    @Override
    @Transactional
    public Boolean addRole(SardlineRoleReq req) {
        String menus = req.getMenus();
        String apis = req.getApis();
        String[] menuList = menus.split(",");
        String[] apiList = apis.split(",");
//添加角色表
        sardlineRoleDao.insert(req);

        SardlineRoleOrg rg = new SardlineRoleOrg();
        rg.setOrgId(req.getOrgId());
        rg.setRoleId(req.getRoleId());
        sardlineRoleOrgDao.insert(rg);
        //添加角色-api表
        for (String api : apiList) {
            SardlineRoleApi apiEntity = new SardlineRoleApi();
            apiEntity.setRoleId(req.getRoleId());
            apiEntity.setApiId(api);
            sardlineRoleApiDao.insert(apiEntity);
        }
        //添加角色-菜单表
        for (String menu : menuList) {
            SardlineRoleMenu roleMenu = new SardlineRoleMenu();
            roleMenu.setMenuId(menu);
            roleMenu.setRoleId(req.getRoleId());
            sardlineRoleMenuDao.insert(roleMenu);
        }

        return true;
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
        StringBuilder menusStr = new StringBuilder();
        for (SardlineMenu menu : menus) {
            allMenu.put(menu.getMenuId(), BeanUtil.toBean(menu, MenuVo.class));
            menusStr.append(menu.getMenuId() + ",");
        }
        String rootid = "-1";

        for (SardlineMenu menu : menus) {
            String pid = menu.getPid();

            List<ApiVo> apis = sardlineApiDao.queryByMenuId(menu.getMenuId());

            List<MenuVo> menuVoList = new ArrayList<>();

            for (ApiVo api : apis) {
                MenuVo menuVo = new MenuVo();
                menuVo.setIsCatalog(30);
                menuVo.setMenuName(api.getApiName());
                menuVo.setMenuPath(api.getApiUrl());
                menuVo.setMenuId(api.getApiId());
                menuVo.setDescription(api.getDescription());
                menuVo.setPid(api.getPid());
                menuVo.setSort(api.getSort());
                menuVoList.add(menuVo);
            }
            MenuVo menu1 = allMenu.get(menu.getMenuId());
            menu1.getChildren().addAll(menuVoList);

            if (pid != null) {
                MenuVo menu2 = allMenu.get(pid);
                if (menu2 != null) {
                    menu2.getChildren().add(allMenu.get(menu.getMenuId()));
                }

            }
        }

        return allMenu.get(rootid);
    }


    public PageInfo<RoleVo> queryForPage(PageParm pageParm, SardlineRole req) {
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(req);
        PageHelper.startPage(pageParm.getPageNum(), pageParm.getPageSize());
        List<RoleVo> sardlineRoles = this.sardlineRoleDao.queryForPage(stringObjectMap);

        for (RoleVo role : sardlineRoles) {
            List<SardlineMenu> sardlineMenus = sardlineRoleMenuDao.queryByRoleId(role.getRoleId());


            StringBuilder menuSb = new StringBuilder();
            StringBuilder apiSb = new StringBuilder();


            for (SardlineMenu menu : sardlineMenus) {
                if (menu.getMenuId() != null) {
                    menuSb.append(menu.getMenuId() + ",");
                }
            }


            String menuStr = menuSb.toString();
            if (menuStr.length() > 0) {
                role.setMenus(menuStr.substring(0, menuStr.length() - 1));
            }
            List<SardlineRoleApi> sardlineRoleApis = sardlineRoleApiDao.queryByRoleId(role.getRoleId());

            for (SardlineRoleApi api : sardlineRoleApis) {
                if (api.getId() != null) {
                    apiSb.append(api.getId() + ",");
                }
            }

            String apiStr = apiSb.toString();
            if (apiStr.length() > 0) {
                role.setApis(apiStr.substring(0, apiStr.length() - 1));

            }
        }

        return new PageInfo<>(sardlineRoles);


//        List<SardlineRole> sardlineRoles = this.sardlineRoleDao.queryForPage(stringObjectMap);
//        Integer count = sardlineRoleDao.queryCountForPage(stringObjectMap);
//
//        return PageResult.success(sardlineRoles, count);

    }

    @Override
    @Transactional
    public Boolean delete(String roleId) {

        this.sardlineRoleDao.deleteById(roleId);
//        sardlineRoleMenuService.deleteByRoleId();

        //删除角色关联功能
        sardlineRoleApiDao.deleteByRoleTd(roleId);

        //删除角色关联菜单
        sardlineRoleMenuDao.deleteByRoleId(roleId);
        //删除角色关联人员
        sardlineUserRoleDao.deleteByRoleId(roleId);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateRole(SardlineRoleReq req) {
        sardlineRoleDao.update1(req);
        String menus = req.getMenus();
        String apis = req.getApis();
        String[] menuList = menus.split(",");
        String[] apiList = apis.split(",");
//修改功能表
        SardlineRoleOrg rg = new SardlineRoleOrg();
        rg.setOrgId(req.getOrgId());
        rg.setRoleId(req.getRoleId());
        sardlineRoleOrgDao.updateRoleOrg(rg);

        sardlineRoleApiDao.deleteByRoleTd(req.getRoleId());

        //添加角色-api表
        for (String api : apiList) {
            SardlineRoleApi apiEntity = new SardlineRoleApi();
            apiEntity.setRoleId(req.getRoleId());
            apiEntity.setApiId(api);
            sardlineRoleApiDao.insert(apiEntity);
        }

        sardlineRoleMenuDao.deleteByRoleId(req.getRoleId());

        //修改菜单表
        for (String menu : menuList) {
            SardlineRoleMenu roleMenu = new SardlineRoleMenu();
            roleMenu.setMenuId(menu);
            roleMenu.setRoleId(req.getRoleId());
            sardlineRoleMenuDao.insert(roleMenu);
        }

        return true;
    }


}