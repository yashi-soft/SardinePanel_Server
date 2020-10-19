package com.example.mysecurity.mapper;

import com.example.mysecurity.entity.SardlineRole;
import com.example.mysecurity.entity.SardlineUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SardlineUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SardlineUserRole queryById(String id);


    /**
     *
     * @param userId
     * @return
     */
    List<SardlineUserRole> queryByUserId(String userId);

    List<SardlineRole> queryRolesByUserId(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineUserRole 实例对象
     * @return 对象列表
     */
    List<SardlineUserRole> queryAll(SardlineUserRole sardlineUserRole);

    /**
     * 新增数据
     *
     * @param sardlineUserRole 实例对象
     * @return 影响行数
     */
    int insert(SardlineUserRole sardlineUserRole);

    /**
     * 修改数据
     *
     * @param sardlineUserRole 实例对象
     * @return 影响行数
     */
    int update(SardlineUserRole sardlineUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<String> queryRoleIdByUserId(String userId);

    void deleteByUserId(@Param("userId")String userId);

    List<String> getRoleName(@Param("userId")String userId);
}