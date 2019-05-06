package com.achan.service;

import com.achan.entity.StorehouseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: StorehouseService
 * @description: TODO
 * @date 2019/4/16
 */
public interface StorehouseService {

    int add(StorehouseVo storeHouseVo);

    int update(StorehouseVo storeHouseVo);

    int delete(String id);

    PageInfo getStorehousePage(StorehouseVo storeHouseVo, int page, int num);

    StorehouseVo getById(String id);

    List<StorehouseVo> getAll();

    List<String> getByUserId(String id);
}
