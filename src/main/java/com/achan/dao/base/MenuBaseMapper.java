package com.achan.dao.base;

import com.achan.entity.base.MenuBase;
import com.achan.entity.base.MenuBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuBaseMapper {
    int countByExample(MenuBaseExample example);

    int deleteByExample(MenuBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(MenuBase record);

    int insertSelective(MenuBase record);

    List<MenuBase> selectByExample(MenuBaseExample example);

    MenuBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MenuBase record, @Param("example") MenuBaseExample example);

    int updateByExample(@Param("record") MenuBase record, @Param("example") MenuBaseExample example);

    int updateByPrimaryKeySelective(MenuBase record);

    int updateByPrimaryKey(MenuBase record);
}