package com.achan.dao;

import com.achan.dao.base.UserRoleBaseMapper;
import com.achan.entity.base.UserRoleBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AChan
 * @title: UserRoleDao
 * @description: TODO
 * @date 2019/4/12
 */
public interface UserRoleDao extends UserRoleBaseMapper {

    /**
     * @Author AChan
     * @Description 获取用户角色Id
     * @Date 2019/4/12
     * @param userId
     * @return java.util.List<java.lang.String>
     **/
    List<String> selectByUser(@Param("user_id") String userId);

    int deleteUserRole(@Param("user_id") String id);

    int batcnInsert(@Param("list") List<UserRoleBase> userRoleBaseList);
}
