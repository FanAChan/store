package com.achan.service;

import com.achan.entity.StoreHouseVo;

import java.util.List;

/**
 * @author AChan
 * @title: StorehouseService
 * @description: TODO
 * @date 2019/4/16
 */
public interface StorehouseService {

    int add(StoreHouseVo storeHouseVo);

    int update(StoreHouseVo storeHouseVo);

    int delete(String id);

    List<StoreHouseVo> getStorehousePage(StoreHouseVo storeHouseVo, int page, int num);

    StoreHouseVo getById(String id);
}
