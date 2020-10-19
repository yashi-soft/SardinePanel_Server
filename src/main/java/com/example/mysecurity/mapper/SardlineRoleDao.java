package com.example.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysecurity.entity.SardlineRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (SardlineRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineRoleDao extends BaseMapper<SardlineRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SardlineRole queryById(String roleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<SardlineRole> queryAll();

    List<SardlineRole> queryForPage(Map map);

    Integer queryCountForPage(Map map);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineRole 实例对象
     * @return 对象列表
     */
    List<SardlineRole> queryAll(SardlineRole sardlineRole);

    /**
     * 新增数据
     *
     * @param sardlineRole 实例对象
     * @return 影响行数
     */
    int insert1(SardlineRole sardlineRole);

    /**
     * 修改数据
     *
     * @param sardlineRole 实例对象
     * @return 影响行数
     */
    int update1(SardlineRole sardlineRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById1(String roleId);

}