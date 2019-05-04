package com.achan.service;

import com.achan.entity.RoleVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: RoleService
 * @description: TODO
 * @date 2019/4/16
 */
public interface RoleService {

    /**
     * 删除
     *
     * @param id
     * @return int
     * @Author AChan
     * @Date 2019/4/18 11:43
     **/
    int delete(String id);

    /**
     * 新增
     *
     * @param role
     * @return int
     * @Author AChan
     * @Date 2019/4/18 11:43
     **/
    int add(RoleVo role);

    /**
     * 修改
     *
     * @param role
     * @return int
     * @Author AChan
     * @Date 2019/4/18 11:43
     **/
    int update(RoleVo role);

    /**
     * 分页查找
     *
     * @param roleVo
     * @param page
     * @param num
     * @return java.util.List<com.achan.entity.RoleVo>
     * @Author AChan
     * @Date 2019/4/18 11:44
     **/
    PageInfo pageRole(RoleVo roleVo, int page, int num);

    /**
     * 获取所有角色
     *
     * @param
     * @return java.util.List<com.achan.entity.RoleVo>
     * @Author AChan
     * @Date 2019/4/18 11:44
     **/
    List<RoleVo> getAll();

    /**
     * 根据Id获取详细信息
     *
     * @param id
     * @return com.achan.entity.RoleVo
     * @Author AChan
     * @Date 2019/4/18 11:44
     **/
    RoleVo getById(String id);

    List<RoleVo> getByIdList(List<String> idList);

    List<RoleVo> selectByUser(String userId);
}
