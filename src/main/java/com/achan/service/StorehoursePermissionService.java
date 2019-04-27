package com.achan.service;

import com.achan.entity.StorehousePermissionVo;
import com.achan.entity.base.StorehousePermissionBase;

import java.util.List;

/**
 * @author AChan
 * @title: StorehoursePermissionService
 * @description: TODO
 * @date 2019/4/16
 */
public interface StorehoursePermissionService {

    int add(StorehousePermissionVo storehousePermissionVo);

    int delete(String id);

    List<StorehousePermissionVo> getByStoreHouseId(String id);

    List<StorehousePermissionVo> getByUserId(String id);

}
