package com.example.mysecurity.mapper;

import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.entity.SardlineUserOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SardlineUserOrg)表数据库访问层
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineUserOrgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineUserOrg queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUserOrg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineUserOrg 实例对象
     * @return 对象列表
     */
    List<SardlineUserOrg> queryAll(SardlineUserOrg sardlineUserOrg);

    /**
     * 新增数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 影响行数
     */
    int insert(SardlineUserOrg sardlineUserOrg);

    /**
     * 修改数据
     *
     * @param sardlineUserOrg 实例对象
     * @return 影响行数
     */
    int update(SardlineUserOrg sardlineUserOrg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<SardlineOrganization> queryByUserId(String userId);

    void deleteByUserId(String userId);

    String getOrgId(@Param("userId")String userId);

    String getOrgName(@Param("userId")String userId);

    Boolean deleteByOrgId(String orgId);
}