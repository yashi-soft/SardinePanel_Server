package com.example.mysecurity.service.impl;

import com.example.mysecurity.entity.SarlineToken;
import com.example.mysecurity.mapper.SarlineTokenDao;
import com.example.mysecurity.service.SarlineTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SarlineToken)表服务实现类
 *
 * @author makejava
 * @since 2020-11-06 14:25:46
 */
@Service("sarlineTokenService")
public class SarlineTokenServiceImpl implements SarlineTokenService {
    @Resource
    private SarlineTokenDao sarlineTokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SarlineToken queryById(String id) {
        return this.sarlineTokenDao.queryById(id);
    }
    @Override
    public SarlineToken queryByName(String name) {
        return this.sarlineTokenDao.queryByName(name);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SarlineToken> queryAllByLimit(int offset, int limit) {
        return this.sarlineTokenDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sarlineToken 实例对象
     * @return 实例对象
     */
    @Override
    public SarlineToken insert(SarlineToken sarlineToken) {
        this.sarlineTokenDao.insert(sarlineToken);
        return sarlineToken;
    }

    /**
     * 修改数据
     *
     * @param sarlineToken 实例对象
     * @return 实例对象
     */
    @Override
    public SarlineToken update(SarlineToken sarlineToken) {
        this.sarlineTokenDao.update(sarlineToken);
        return this.queryById(sarlineToken.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sarlineTokenDao.deleteById(id) > 0;
    }
}