package com.example.mysecurity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.common.ResultCode;
import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.SardlineUserRole;
import com.example.mysecurity.entity.base.PageParm;
import com.example.mysecurity.entity.req.SardineUserReq;
import com.example.mysecurity.entity.so.UserListSo;
import com.example.mysecurity.mapper.SardlineUserDao;
import com.example.mysecurity.mapper.SardlineUserOrgDao;
import com.example.mysecurity.mapper.SardlineUserRoleDao;
import com.example.mysecurity.service.SardlineRoleService;
import com.example.mysecurity.service.SardlineUserOrgService;
import com.example.mysecurity.service.SardlineUserRoleService;
import com.example.mysecurity.service.SardlineUserService;
import com.example.mysecurity.utils.BCryptPasswordUtil;
import com.example.mysecurity.vo.RoleVo;
import com.example.mysecurity.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (SardlineUser)表服务实现类
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineUserService")
@Slf4j
public class SardlineUserServiceImpl extends ServiceImpl<SardlineUserDao, SardlineUser> implements SardlineUserService {
    @Resource
    private SardlineUserDao sardlineUserDao;
    @Autowired
    BCryptPasswordUtil passwordUtil;

    @Resource
    private SardlineUserRoleService sardlineUserRoleService;
    @Resource
    private SardlineRoleService sardlineRoleService;

    @Resource
    private SardlineUserOrgDao sardlineUserOrgDao;

    @Resource
    private SardlineUserRoleDao sardlineUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SardlineUser queryById(String userId) {
        return this.sardlineUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineUser> queryAllByLimit(int offset, int limit) {
        return this.sardlineUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUser insert(SardlineUser sardlineUser) {
        this.sardlineUserDao.insert(sardlineUser);
        return sardlineUser;
    }

    /**
     * 修改数据
     *
     * @param sardlineUser 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineUser update(SardlineUser sardlineUser) {
        sardlineUser.setUpdateTime(new Date());
        this.sardlineUserDao.updateUser(sardlineUser);
        return this.queryById(sardlineUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.sardlineUserDao.deleteById(userId) > 0;
    }

    @Override
    public SardlineUser queryByName(String name) {
        return this.sardlineUserDao.queryByName(name);
    }

    @Override
    public Result register(SardlineUser user) {
        Result result = new Result();
        SardlineUser sardlineUser = this.sardlineUserDao.queryByName(user.getUserName());

        if (sardlineUser != null) {
            result.setCode(ResultCode.FAIL);
            result.setMsg("此用户已存在");
            return result;
        }
        user.setPassWord(passwordUtil.encode(user.getPassWord()));
        user.setRegisterTime(new Date());
        user.setUpdateTime(new Date());
        int insert = this.sardlineUserDao.insert(user);
        if (insert > 0) {
            result.setCode(ResultCode.SUCCESS);
            result.setMsg("新增成功");
        } else {
            result.setCode(ResultCode.FAIL);
            result.setMsg("新增失败");
        }
        return result;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        SardlineUser userEntity = this.baseMapper.queryByName(username);
        log.info("userEntity =========={} ", userEntity.toString());
        if (userEntity == null) {
            //System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            //设置友好提示
//            throw  new Exception("账号不存在，请重新尝试！");
            return false;
        } else {
            //加密的密码
            String encodedPassword = userEntity.getPassWord();
            //和加密后的密码进行比配
            if (!passwordUtil.matches(password, encodedPassword)) {
                //System.out.println("checkLogin--------->密码不正确！");
                //设置友好提示
//                throw new Exception("密码不正确！");
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public UserVo queryUserForLogin(String username) {
        SardlineUser sardlineUser = this.sardlineUserDao.queryByName(username);
        UserVo userVo = null;
        if (sardlineUser != null) {
            userVo = BeanUtil.toBean(sardlineUser, UserVo.class);

            List<SardlineUserRole> sardlineUserRoles = sardlineUserRoleService.queryByUserId(sardlineUser.getUserId());
            for (SardlineUserRole role : sardlineUserRoles) {
                SardlineRole sardlineRole = sardlineRoleService.queryById(role.getRoleId());
                RoleVo roleVo = BeanUtil.toBean(sardlineRole, RoleVo.class);
                userVo.getRoles().add(roleVo);
            }
        }


        return userVo;
    }

    @Override
    public PageInfo<UserListSo> queryAll(PageParm pageParm, SardlineUser sardlineUser) {

        PageHelper.startPage(pageParm.getPageNum(), pageParm.getPageSize());
        PageInfo<UserListSo> pageInfo = new PageInfo<>(sardlineUserDao.queryAll(sardlineUser));
        if (CollectionUtils.isEmpty(pageInfo.getList())) {
            return pageInfo;
        }
        List<UserListSo> list = pageInfo.getList();
        for (int i = 0; i < list.size(); i++) {
            UserListSo userListSo = list.get(i);
            List<String> id = sardlineUserRoleDao.getRoleId(userListSo.getUserId());
            String ids = String.join(",", id);
            userListSo.setRoleIds(ids);
            List<String> name = sardlineUserRoleDao.getRoleName(userListSo.getUserId());
            String names = String.join(",", name);
            userListSo.setRoleList(names);
            String orgId = sardlineUserOrgDao.getOrgId(userListSo.getUserId());
            userListSo.setOrganizationIds(orgId == null ? "" : String.join(",", orgId));
            String orgName = sardlineUserOrgDao.getOrgName(userListSo.getUserId());
            userListSo.setOrganizationList(orgName == null ? "" : String.join(",", orgName));
        }
        return pageInfo;

    }

    @Override
    public Boolean delete(String userId) {
        //删除用户角色信息
        sardlineUserRoleDao.deleteByUserId(userId);
        //删除用户组织信息
        sardlineUserOrgDao.deleteByUserId(userId);
        //删除用户信息
        sardlineUserDao.deleteById(userId);
        return true;
    }

    @Override
    public Result updatePassword(SardineUserReq req) {


        SardlineUser sardlineUser = sardlineUserDao.queryByName(req.getUserName());


        if (sardlineUser == null) {
            return Result.fail(1001, "该用户不存在");
        } else {
            //加密的密码
            String encodedPassword = sardlineUser.getPassWord();
            //和加密后的密码进行比配
            if (!passwordUtil.matches(req.getOldPassword(), encodedPassword)) {
                return Result.fail(1002, "原密码错误");
            } else {
                sardlineUser.setPassWord(passwordUtil.encode(req.getNewPassword()));
                sardlineUser.setUpdateTime(DateUtil.date());
                sardlineUserDao.updateUser(sardlineUser);
                return Result.success();
            }
        }

    }
}