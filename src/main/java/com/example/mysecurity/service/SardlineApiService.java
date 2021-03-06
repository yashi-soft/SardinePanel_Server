package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineApi;
import java.util.List;
import java.util.Map;

/**
 * (SardlineApi)表服务接口
 *
 * @author fjx
 * @since 2020-10-10 10:40:55
 */
public interface SardlineApiService {

    /**
     * 通过ID查询单条数据
     *
     * @param apiId 主键
     * @return 实例对象
     */
    SardlineApi queryById(String apiId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineApi> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sardlineApi 实例对象
     * @return 实例对象
     */
    SardlineApi insert(SardlineApi sardlineApi);

    /**
     * 修改数据
     *
     * @param sardlineApi 实例对象
     * @return 实例对象
     */
    SardlineApi update(SardlineApi sardlineApi);

    /**
     * 通过主键删除数据
     *
     * @param apiId 主键
     * @return 是否成功
     */
    boolean deleteById(String apiId);

    String getApiNameByUrl(String apiUrl);

    List<SardlineApi> getApiUrlByUserName(String username);


    Map<String,SardlineApi> getUrlMap(String username);

    Boolean add(SardlineApi api);

    List<SardlineApi> selectUsualApi();

    Map<String,SardlineApi> selectUsualApiMap();
}