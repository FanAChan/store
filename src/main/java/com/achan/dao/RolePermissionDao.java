package com.achan.dao;

import com.achan.dao.base.RolePermissionBaseMapper;
import com.achan.dao.base.UserRoleBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AChan
 * @title: UserRoleDao
 * @description: TODO
 * @date 2019/4/12
 */
public interface RolePermissionDao extends RolePermissionBaseMapper {

    /**
     * @Author AChan
     * @Description 获取用户角色Id
     * @Date 2019/4/12
     * @param userId
     * @return java.util.List<java.lang.String>
     **/
    List<String> selectByRoleIdList(@Param("list") List<String> roleIdList);
}
