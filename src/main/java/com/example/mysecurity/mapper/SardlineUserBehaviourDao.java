package com.example.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.entity.SardlineUserBehaviour;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (SardlineUserBehaviour)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-11 11:17:07
 */
@Mapper
public interface SardlineUserBehaviourDao extends BaseMapper<SardlineUserBehaviour> {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    List<SardlineUserBehaviour> queryById(@Param("userId") String userId, @Param("startTime")String startTime);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUserBehaviour> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 通过用户名字模糊查询
     *
     * */
    List<SardlineUserBehaviour> queryByName(@Param("name") String name);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 对象列表
     */
//    List<SardlineUserBehaviour> queryAll(SardlineUserBehaviour sardlineUserBehaviour);

    /**
     * 新增数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 影响行数
     */
    int insert(SardlineUserBehaviour sardlineUserBehaviour);

    /**
     * 修改数据
     *
     * @param sardlineUserBehaviour 实例对象
     * @return 影响行数
     */
//    int updateById(SardlineUserBehaviour sardlineUserBehaviour);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(@Param("userId") String userId);

}