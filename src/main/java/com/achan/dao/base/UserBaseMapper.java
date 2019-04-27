package com.achan.dao.base;

import com.achan.entity.base.UserBase;
import com.achan.entity.base.UserBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBaseMapper {
    int countByExample(UserBaseExample example);

    int deleteByExample(UserBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    List<UserBase> selectByExample(UserBaseExample example);

    UserBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}