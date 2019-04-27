package com.achan.dao.base;

import com.achan.entity.base.StorehouseStockBase;
import com.achan.entity.base.StorehouseStockBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorehouseStockBaseMapper {
    int countByExample(StorehouseStockBaseExample example);

    int deleteByExample(StorehouseStockBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(StorehouseStockBase record);

    int insertSelective(StorehouseStockBase record);

    List<StorehouseStockBase> selectByExample(StorehouseStockBaseExample example);

    StorehouseStockBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StorehouseStockBase record, @Param("example") StorehouseStockBaseExample example);

    int updateByExample(@Param("record") StorehouseStockBase record, @Param("example") StorehouseStockBaseExample example);

    int updateByPrimaryKeySelective(StorehouseStockBase record);

    int updateByPrimaryKey(StorehouseStockBase record);
}