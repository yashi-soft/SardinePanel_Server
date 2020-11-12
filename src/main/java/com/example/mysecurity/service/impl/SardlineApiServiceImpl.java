package com.example.mysecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.entity.SardlineRoleApi;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.mapper.SardlineApiDao;
import com.example.mysecurity.mapper.SardlineRoleApiDao;
import com.example.mysecurity.mapper.SardlineUserDao;
import com.example.mysecurity.service.SardlineApiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SardlineApi)表服务实现类
 *
 * @author fjx
 * @since 2020-10-10 10:40:55
 */
@Service("sardlineApiService")
public class SardlineApiServiceImpl extends ServiceImpl<SardlineApiDao, SardlineApi> implements SardlineApiService {
    @Resource
    private SardlineApiDao sardlineApiDao;


    @Resource
    private SardlineRoleApiDao sardlineRoleApiDao;


    /**
     * 通过ID查询单条数据
     *
     * @param apiId 主键
     * @return 实例对象
     */
    @Override
    public SardlineApi queryById(String apiId) {
        return this.sardlineApiDao.queryById(apiId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SardlineApi> queryAllByLimit(int offset, int limit) {
        return this.sardlineApiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sardlineApi 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineApi insert(SardlineApi sardlineApi) {
        this.sardlineApiDao.insert(sardlineApi);
        return sardlineApi;
    }

    /**
     * 修改数据
     *
     * @param sardlineApi 实例对象
     * @return 实例对象
     */
    @Override
    public SardlineApi update(SardlineApi sardlineApi) {
        this.sardlineApiDao.updateApi(sardlineApi);
        return this.queryById(sardlineApi.getApiId());
    }

    /**
     * 通过主键删除数据
     *
     * @param apiId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String apiId) {

//        sardlineRoleApiDao.

        return this.sardlineApiDao.deleteById(apiId) > 0;
    }

    @Override
    public List<SardlineApi> getApiUrlByUserName(String username) {
        return this.sardlineApiDao.getApiUrlByUserName(username);
    }

    @Override
    @Transactional
    public Boolean add(SardlineApi api) {

        SardlineApi insert = this.insert(api);
        SardlineRoleApi ra = new SardlineRoleApi();
        ra.setApiId(api.getApiId());
        ra.setRoleId("1");
        Integer flag = sardlineRoleApiDao.insert(ra);

        return flag > 0;
    }

    @Override
    public List<SardlineApi> selectUsualApi() {
        return sardlineApiDao.selectUsualApi();
    }


}