package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.StorehousePermissionVo;
import com.achan.service.StorehoursePermissionService;
import com.achan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AChan
 * @title: StorehousePermissionController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/storehousepermission")
public class StorehousePermissionController {

    @Autowired
    private StorehoursePermissionService storehoursePermissionService;


    public CommonResponse add(StorehousePermissionVo storehousePermissionVo) {
        storehousePermissionVo.setId(UUIDUtil.randomID());
        int add = storehoursePermissionService.add(storehousePermissionVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    public CommonResponse delete(String id) {
        int delete = storehoursePermissionService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    public CommonResponse update(StorehousePermissionVo storehousePermissionVo) {
        int add = storehoursePermissionService.add(storehousePermissionVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    public CommonResponse page(String id, int pageNum, int pageSize) {
        return null;
    }

}
