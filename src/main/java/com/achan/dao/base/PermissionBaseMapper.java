package com.achan.dao.base;

import com.achan.entity.base.PermissionBase;
import com.achan.entity.base.PermissionBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionBaseMapper {
    int countByExample(PermissionBaseExample example);

    int deleteByExample(PermissionBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(PermissionBase record);

    int insertSelective(PermissionBase record);

    List<PermissionBase> selectByExample(PermissionBaseExample example);

    PermissionBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PermissionBase record, @Param("example") PermissionBaseExample example);

    int updateByExample(@Param("record") PermissionBase record, @Param("example") PermissionBaseExample example);

    int updateByPrimaryKeySelective(PermissionBase record);

    int updateByPrimaryKey(PermissionBase record);
}