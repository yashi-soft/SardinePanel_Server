package com.example.mysecurity.mapper;

import com.example.mysecurity.entity.SardlineRoleApi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SardlineRoleApi)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-16 10:15:18
 */
@Mapper
public interface SardlineRoleApiDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineRoleApi queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SardlineRoleApi> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineRoleApi 实例对象
     * @return 对象列表
     */
    List<SardlineRoleApi> queryAll(SardlineRoleApi sardlineRoleApi);

    /**
     * 新增数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 影响行数
     */
    int insert(SardlineRoleApi sardlineRoleApi);

    /**
     * 修改数据
     *
     * @param sardlineRoleApi 实例对象
     * @return 影响行数
     */
    int update(SardlineRoleApi sardlineRoleApi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}