package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import com.achan.entity.StorehouseVo;
import com.achan.service.StorehouseService;
import com.achan.util.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: StorehouseController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/storehouse")
public class StorehouseController {

    @Autowired
    private StorehouseService storehouseService;

    @PostMapping("/add")
    private CommonResponse add(StorehouseVo storeHouseVo) {
        storeHouseVo.setId(UUIDUtil.randomID());
        int add = storehouseService.add(storeHouseVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    private CommonResponse update(StorehouseVo storeHouseVo) {
        int update = storehouseService.update(storeHouseVo);
        if (update == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }


    @PostMapping("/delete")
    private CommonResponse delete(String id) {
        int delete = storehouseService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/page")
    private CommonResponse page(@RequestParam(required = false) StorehouseVo storeHouseVo, int pageNum, int pageSize) {
        PageInfo storehousePage = storehouseService.getStorehousePage(storeHouseVo, pageNum, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", storehousePage);
        return CommonResponse.success(data);
    }

    @GetMapping("/all")
    private CommonResponse all() {
        List storehousePage = storehouseService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", storehousePage);
        return CommonResponse.success(data);
    }

    @GetMapping("/detail")
    private CommonResponse getById(String id) throws StoreException {
        StorehouseVo storeHouseVo = storehouseService.getById(id);
        if (ObjectUtils.isEmpty(storeHouseVo)) {
            throw new StoreException();
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("storeHouseVo", storeHouseVo);
        return CommonResponse.success(data);
    }

    @GetMapping("/userStorehouse")
    private CommonResponse getByUserId(String id) throws StoreException {
        List<String> storehouseIdList = storehouseService.getByUserId(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", storehouseIdList);
        return CommonResponse.success(data);
    }
}
