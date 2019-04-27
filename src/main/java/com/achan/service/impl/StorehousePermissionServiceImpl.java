package com.achan.service.impl;

import com.achan.entity.StorehousePermissionVo;
import com.achan.service.StorehoursePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AChan
 * @title: StorehousePermissionServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("storehousePermissionService")
public class StorehousePermissionServiceImpl implements StorehoursePermissionService {

    @Override
    public int add(StorehousePermissionVo storehousePermissionVo) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public List<StorehousePermissionVo> getByStoreHouseId(String id) {
        return null;
    }

    @Override
    public List<StorehousePermissionVo> getByUserId(String id) {
        return null;
    }
}
