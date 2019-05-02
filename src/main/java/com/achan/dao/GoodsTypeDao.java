package com.achan.dao;

import com.achan.dao.base.GoodsTypeBaseMapper;
import com.achan.entity.base.GoodsTypeBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeDao extends GoodsTypeBaseMapper {


    List<GoodsTypeBase> selectByIds(@Param("ids") List<String> ids);
}
