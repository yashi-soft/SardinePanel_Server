package com.example.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysecurity.entity.SardlineUser;
import com.example.mysecurity.entity.so.UserListSo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SardlineUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineUserDao  extends BaseMapper<SardlineUser> {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SardlineUser queryById(String userId);


    SardlineUser queryByName(@Param("name")String name);


    SardlineUser queryByNameForLogin(@Param("name")String name);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineUser 实例对象
     * @return 对象列表
     */
    List<UserListSo> queryAll(SardlineUser sardlineUser);


    void updateUser(SardlineUser sardlineUser);

}