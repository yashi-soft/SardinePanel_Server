package com.example.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysecurity.entity.SardlineMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SardlineMenu)表数据库访问层
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
@Mapper
public interface SardlineMenuDao extends BaseMapper<SardlineMenu> {

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SardlineMenu queryById(String menuId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SardlineMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sardlineMenu 实例对象
     * @return 对象列表
     */
    List<SardlineMenu> queryAll(SardlineMenu sardlineMenu);


    int updateByMenuId(SardlineMenu sardlineMenu);


}