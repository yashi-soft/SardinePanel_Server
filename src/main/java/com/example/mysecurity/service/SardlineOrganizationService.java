package com.example.mysecurity.service;

import com.example.mysecurity.entity.SardlineOrganization;
import com.example.mysecurity.vo.OrgVo;

import java.util.List;

/**
 * (SardlineOrganization)表服务接口
 *
 * @author fjx
 * @since 2020-10-10 10:40:57
 */
public interface SardlineOrganizationService {

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    SardlineOrganization queryById(String orgId);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SardlineOrganization> queryAllByLimit(int offset, int limit);
    /**
     * 新增数据
     *
     * @param sardlineOrganization 实例对象
     * @return 实例对象
     */
    SardlineOrganization insert(SardlineOrganization sardlineOrganization);
    /**
     * 修改数据
     *
     * @param sardlineOrganization 实例对象
     * @return 实例对象
     */
    SardlineOrganization update(SardlineOrganization sardlineOrganization);
    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 是否成功
     */
    boolean deleteById(String orgId);

    List<SardlineOrganization> queryAll();

    OrgVo queryByName(String orgName);

    Boolean delete(String orgId);
}