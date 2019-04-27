package com.achan.dao;

import com.achan.dao.base.StorehouseBaseMapper;
import com.achan.entity.StoreHouseVo;

import java.util.List;

public interface StorehouseDao extends StorehouseBaseMapper {


    List<StoreHouseVo> selectByVo(StoreHouseVo storeHouseVo);

}
