package com.achan.dao.base;

import com.achan.entity.base.RolePermissionBase;
import com.achan.entity.base.RolePermissionBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionBaseMapper {
    int countByExample(RolePermissionBaseExample example);

    int deleteByExample(RolePermissionBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(RolePermissionBase record);

    int insertSelective(RolePermissionBase record);

    List<RolePermissionBase> selectByExample(RolePermissionBaseExample example);

    RolePermissionBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RolePermissionBase record, @Param("example") RolePermissionBaseExample example);

    int updateByExample(@Param("record") RolePermissionBase record, @Param("example") RolePermissionBaseExample example);

    int updateByPrimaryKeySelective(RolePermissionBase record);

    int updateByPrimaryKey(RolePermissionBase record);
}