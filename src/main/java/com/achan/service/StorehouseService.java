package com.achan.service;

import com.achan.entity.StoreHouseVo;
import com.github.pagehelper.PageInfo;

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

    PageInfo getStorehousePage(StoreHouseVo storeHouseVo, int page, int num);

    StoreHouseVo getById(String id);
}
