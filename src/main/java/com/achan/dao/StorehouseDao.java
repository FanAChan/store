package com.achan.dao;

import com.achan.dao.base.StorehouseBaseMapper;
import com.achan.entity.StorehouseVo;

import java.util.List;

public interface StorehouseDao extends StorehouseBaseMapper {


    List<StorehouseVo> selectByVo(StorehouseVo storeHouseVo);

}
