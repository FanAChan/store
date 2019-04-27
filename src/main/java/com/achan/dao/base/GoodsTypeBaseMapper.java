package com.achan.dao.base;

import com.achan.entity.base.GoodsTypeBase;
import com.achan.entity.base.GoodsTypeBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeBaseMapper {
    int countByExample(GoodsTypeBaseExample example);

    int deleteByExample(GoodsTypeBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(GoodsTypeBase record);

    int insertSelective(GoodsTypeBase record);

    List<GoodsTypeBase> selectByExample(GoodsTypeBaseExample example);

    GoodsTypeBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GoodsTypeBase record, @Param("example") GoodsTypeBaseExample example);

    int updateByExample(@Param("record") GoodsTypeBase record, @Param("example") GoodsTypeBaseExample example);

    int updateByPrimaryKeySelective(GoodsTypeBase record);

    int updateByPrimaryKey(GoodsTypeBase record);
}