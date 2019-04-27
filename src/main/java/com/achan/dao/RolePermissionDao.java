package com.achan.dao;

import com.achan.dao.base.UserRoleBaseMapper;

import java.util.List;

/**
 * @author AChan
 * @title: UserRoleDao
 * @description: TODO
 * @date 2019/4/12
 */
public interface RolePermissionDao extends UserRoleBaseMapper {

    /**
     * @Author AChan
     * @Description 获取用户角色Id
     * @Date 2019/4/12
     * @param userId
     * @return java.util.List<java.lang.String>
     **/
    List<String> selectByRole(String userId);
}
