package com.achan.dao.base;

import com.achan.entity.base.RoleMenuBase;
import com.achan.entity.base.RoleMenuBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuBaseMapper {
    int countByExample(RoleMenuBaseExample example);

    int deleteByExample(RoleMenuBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleMenuBase record);

    int insertSelective(RoleMenuBase record);

    List<RoleMenuBase> selectByExample(RoleMenuBaseExample example);

    RoleMenuBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleMenuBase record, @Param("example") RoleMenuBaseExample example);

    int updateByExample(@Param("record") RoleMenuBase record, @Param("example") RoleMenuBaseExample example);

    int updateByPrimaryKeySelective(RoleMenuBase record);

    int updateByPrimaryKey(RoleMenuBase record);
}