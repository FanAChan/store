package com.achan.service;

import com.achan.entity.StoreHouseStockVo;

import java.util.List;

/**
 * @author AChan
 * @title: StorehouseStockService
 * @description: TODO
 * @date 2019/4/16
 */
public interface StorehouseStockService {

    int add(StoreHouseStockVo storeHouseStockVo);

    int update(StoreHouseStockVo storeHouseStockVo);

    List<StoreHouseStockVo> page(String userId, StoreHouseStockVo storeHouseStockVo, int page, int num);
}
