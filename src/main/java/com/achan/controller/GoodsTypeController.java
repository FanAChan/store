package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import com.achan.entity.GoodsTypeVo;
import com.achan.service.GoodsTypeService;
import com.achan.util.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: GoodsTypeController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @PostMapping("/add")
    public CommonResponse add(GoodsTypeVo goodsTypeVo) {
        goodsTypeVo.setId(UUIDUtil.randomID());
        int add = goodsTypeService.add(goodsTypeVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    public CommonResponse update(GoodsTypeVo goodsTypeVo) {
        int update = goodsTypeService.update(goodsTypeVo);
        if (update == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int add = goodsTypeService.delete(id);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/detail")
    public CommonResponse getById(String id) throws StoreException {
        GoodsTypeVo goodsTypeVo = goodsTypeService.getById(id);
        if (ObjectUtils.isEmpty(goodsTypeVo)) {
            throw new StoreException();
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("goodsTypeVo", goodsTypeVo);
        CommonResponse success = CommonResponse.success(resultMap);
        return success;
    }


    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) GoodsTypeVo goodsTypeVo,
                               int pageNum, int pageSize) throws StoreException {

        PageInfo result = goodsTypeService.getGoodsTypePage(goodsTypeVo, pageNum, pageSize);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("page", result);
        CommonResponse success = CommonResponse.success(resultMap);
        return success;

    }

    @GetMapping("all")
    public List<GoodsTypeVo> getAll() {
        List<GoodsTypeVo> all = goodsTypeService.getAll();
        return all;
    }
}
