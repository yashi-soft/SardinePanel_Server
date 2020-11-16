package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SardlineUserBehaviour;
import com.example.mysecurity.mapper.SardlineUserBehaviourDao;
import com.example.mysecurity.service.SardlineUserBehaviourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * (SardlineUserBehaviour)表服务实现类
 *
 * @author makejava
 * @since 2020-11-11 11:09:56
 */
@Service("sardlineUserBehaviourService")
public class SardlineUserBehaviourServiceImpl implements SardlineUserBehaviourService {
    @Resource
    private SardlineUserBehaviourDao sardlineUserBehaviourDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public List<SardlineUserBehaviour> queryById(String userId, String startTime) {
        return this.sardlineUserBehaviourDao.queryById(userId,startTime);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineUserBehaviour> queryAllByLimit(int offset, int limit) {
        return this.sardlineUserBehaviourDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(SardlineUserBehaviour sardlineUserBehaviour) {
        return this.sardlineUserBehaviourDao.insert(sardlineUserBehaviour)>0;
    }

    @Override
    public List<SardlineUserBehaviour> queryByName(String name) {
        return this.sardlineUserBehaviourDao.queryByName(name);
    }

    /**
     * 修改数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 实例对象
     */
//    @Override
//    public boolean update(SardlineUserBehaviour sardlineUserBehaviour) {
//        return this.sardlineUserBehaviourDao.update(sardlineUserBehaviour)>0;
//    }

    /*@Override
    public SardlineUserBehaviour update(SardlineUserBehaviour sardlineUserBehaviour) {
        this.sardlineUserBehaviourDao.update(sardlineUserBehaviour);
        return sardlineUserBehaviour;
    }*/

    /**
     * 通过userId删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.sardlineUserBehaviourDao.deleteById(userId) > 0;
    }
}