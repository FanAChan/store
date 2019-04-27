package com.achan.dao.base;

import com.achan.entity.base.UnitBase;
import com.achan.entity.base.UnitBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitBaseMapper {
    int countByExample(UnitBaseExample example);

    int deleteByExample(UnitBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(UnitBase record);

    int insertSelective(UnitBase record);

    List<UnitBase> selectByExample(UnitBaseExample example);

    UnitBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UnitBase record, @Param("example") UnitBaseExample example);

    int updateByExample(@Param("record") UnitBase record, @Param("example") UnitBaseExample example);

    int updateByPrimaryKeySelective(UnitBase record);

    int updateByPrimaryKey(UnitBase record);
}