package com.achan.dao;

import com.achan.dao.base.RoleMenuBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AChan
 * @title: RoleMenuDao
 * @date 2019/4/22
 */
public interface RoleMenuDao extends RoleMenuBaseMapper {

    List<String> selectByRoleIdList(@Param("roleIdList") List<String> roleIdList);
}
