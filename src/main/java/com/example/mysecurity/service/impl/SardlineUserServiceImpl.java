package com.example.mysecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysecurity.common.Result;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.mapper.SardlineUserDao;
import com.example.mysecurity.service.SardlineUserService;
import com.example.mysecurity.utils.BCryptPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (SardlineUser)表服务实现类
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Service("sardlineUserService")
public class SardlineUserServiceImpl extends ServiceImpl<SardlineUserDao, SardlineUser> implements SardlineUserService {
    @Resource
    private SardlineUserDao sardlineUserDao;
    @Autowired
    BCryptPasswordUtil passwordUtil;

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
        this.sardlineUserDao.update(sardlineUser, null);
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
            result.setCode("100000");
            result.setMsg("此用户已存在");
            return result;
        }
//        user.setUserId(UUID.randomUUID().toString());
        user.setPassWord(passwordUtil.encode(user.getPassWord()));
        user.setState(1);
        int insert = this.sardlineUserDao.insert(user);
        if (insert > 0) {
            result.setCode("000000");
            result.setMsg("新增成功");
        } else {
            result.setCode("200000");
            result.setMsg("新增失败");
        }
        return result;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        SardlineUser userEntity = this.baseMapper.queryByName(username);
        System.out.println("userEntity = " + userEntity);
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
}