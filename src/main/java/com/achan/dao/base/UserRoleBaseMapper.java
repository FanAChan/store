package com.achan.dao.base;

import com.achan.entity.base.UserRoleBase;
import com.achan.entity.base.UserRoleBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleBaseMapper {
    int countByExample(UserRoleBaseExample example);

    int deleteByExample(UserRoleBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRoleBase record);

    int insertSelective(UserRoleBase record);

    List<UserRoleBase> selectByExample(UserRoleBaseExample example);

    UserRoleBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRoleBase record, @Param("example") UserRoleBaseExample example);

    int updateByExample(@Param("record") UserRoleBase record, @Param("example") UserRoleBaseExample example);

    int updateByPrimaryKeySelective(UserRoleBase record);

    int updateByPrimaryKey(UserRoleBase record);
}