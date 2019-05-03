package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import com.achan.entity.UnitVo;
import com.achan.service.UnitService;
import com.achan.util.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: UnitController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/add")
    public CommonResponse add(UnitVo unitVo) {
        unitVo.setId(UUIDUtil.randomID());
        int add = unitService.add(unitVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int delete = unitService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    public CommonResponse update(UnitVo unitVo) {
        int delete = unitService.update(unitVo);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) UnitVo unitVo,
                               int pageNum, int pageSize) {
        PageInfo pageInfo = unitService.pageUnitVo(unitVo, pageNum, pageSize);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("page", pageInfo);
        CommonResponse success = CommonResponse.success(resultMap);
        return success;
    }

    @GetMapping("detail")
    public CommonResponse getById(String id) throws StoreException {
        UnitVo unitVo = unitService.getById(id);
        if (ObjectUtils.isEmpty(unitVo)) {
            throw new StoreException();
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("unitVo", unitVo);
        return CommonResponse.success(data);
    }

    @GetMapping("all")
    public CommonResponse getAll() throws StoreException {
        List<UnitVo> unitVoList = unitService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", unitVoList);
        return CommonResponse.success(data);
    }
}
