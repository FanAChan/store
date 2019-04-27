package com.achan.dao.base;

import com.achan.entity.base.RoleBase;
import com.achan.entity.base.RoleBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleBaseMapper {
    int countByExample(RoleBaseExample example);

    int deleteByExample(RoleBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleBase record);

    int insertSelective(RoleBase record);

    List<RoleBase> selectByExample(RoleBaseExample example);

    RoleBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleBase record, @Param("example") RoleBaseExample example);

    int updateByExample(@Param("record") RoleBase record, @Param("example") RoleBaseExample example);

    int updateByPrimaryKeySelective(RoleBase record);

    int updateByPrimaryKey(RoleBase record);
}