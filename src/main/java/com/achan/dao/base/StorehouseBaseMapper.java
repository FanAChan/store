package com.achan.dao.base;

import com.achan.entity.base.StorehouseBase;
import com.achan.entity.base.StorehouseBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorehouseBaseMapper {
    int countByExample(StorehouseBaseExample example);

    int deleteByExample(StorehouseBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(StorehouseBase record);

    int insertSelective(StorehouseBase record);

    List<StorehouseBase> selectByExample(StorehouseBaseExample example);

    StorehouseBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StorehouseBase record, @Param("example") StorehouseBaseExample example);

    int updateByExample(@Param("record") StorehouseBase record, @Param("example") StorehouseBaseExample example);

    int updateByPrimaryKeySelective(StorehouseBase record);

    int updateByPrimaryKey(StorehouseBase record);
}