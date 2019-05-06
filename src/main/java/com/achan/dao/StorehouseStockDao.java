package com.achan.dao;

import com.achan.dao.base.StorehouseStockBaseMapper;
import com.achan.entity.StoreHouseStockVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorehouseStockDao extends StorehouseStockBaseMapper {

    List<StoreHouseStockVo> selectByGoodsIdOrStorehouseId(@Param("goodsId") String goodsId,
                                                          @Param("list") List<String> storehouseIdList);

}
