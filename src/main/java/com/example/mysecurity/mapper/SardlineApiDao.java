package com.example.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysecurity.entity.SardlineApi;
import com.example.mysecurity.vo.ApiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SardlineApi)表数据库访问层
 *
 * @author fjx
 * @since 2020-10-10 10:40:55
 */
@Mapper
public interface SardlineApiDao extends BaseMapper<SardlineApi> {

    /**
     * 通过ID查询单条数据
     *
     * @param apiId 主键
     * @return 实例对象
     */
    SardlineApi queryById(String apiId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SardlineApi> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineApi 实例对象
     * @return 对象列表
     */
    List<SardlineApi> queryAll(SardlineApi sardlineApi);


    List<SardlineApi> getApiUrlByUserName(String username);

    List<SardlineApi> selectUsualApi();


    List<ApiVo> queryByMenuId(String menuId);

    Integer queryCountByMenuId(String menuId);

    Integer deletebyMenuId(String menuId);

    Integer updateApi(SardlineApi sardlineApi);


}


