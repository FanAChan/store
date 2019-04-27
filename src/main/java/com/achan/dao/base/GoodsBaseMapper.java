package com.achan.dao.base;

import com.achan.entity.base.GoodsBase;
import com.achan.entity.base.GoodsBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsBaseMapper {
    int countByExample(GoodsBaseExample example);

    int deleteByExample(GoodsBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(GoodsBase record);

    int insertSelective(GoodsBase record);

    List<GoodsBase> selectByExample(GoodsBaseExample example);

    GoodsBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GoodsBase record, @Param("example") GoodsBaseExample example);

    int updateByExample(@Param("record") GoodsBase record, @Param("example") GoodsBaseExample example);

    int updateByPrimaryKeySelective(GoodsBase record);

    int updateByPrimaryKey(GoodsBase record);
}