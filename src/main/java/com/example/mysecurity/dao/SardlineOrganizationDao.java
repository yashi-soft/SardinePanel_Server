package com.example.mysecurity.dao;

import com.example.mysecurity.entity.SardlineOrganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SardlineOrganization)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineOrganizationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    SardlineOrganization queryById(String orgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineOrganization> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineOrganization 实例对象
     * @return 对象列表
     */
    List<SardlineOrganization> queryAll(SardlineOrganization sardlineOrganization);

    /**
     * 新增数据
     *
     * @param sardlineOrganization 实例对象
     * @return 影响行数
     */
    int insert(SardlineOrganization sardlineOrganization);

    /**
     * 修改数据
     *
     * @param sardlineOrganization 实例对象
     * @return 影响行数
     */
    int update(SardlineOrganization sardlineOrganization);

    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 影响行数
     */
    int deleteById(String orgId);

}