package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import com.achan.entity.GoodsVo;
import com.achan.service.GoodsService;
import com.achan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: GoodsController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    public CommonResponse add(GoodsVo goodsVo) {
        goodsVo.setId((UUIDUtil.randomID()));
        int add = goodsService.add(goodsVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    public CommonResponse update(GoodsVo goodsVo) {
        int add = goodsService.update(goodsVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int add = goodsService.delete(id);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/detail")
    public CommonResponse getById(String id) throws StoreException {
        GoodsVo goodsVo = goodsService.getById(id);
        if (ObjectUtils.isEmpty(goodsVo)) {
            throw new StoreException();
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("goodsVo", goodsVo);
        CommonResponse success = CommonResponse.success(resultMap);
        return success;
    }


    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) GoodsVo goodsVo, int page, int num) throws StoreException {

        List<GoodsVo> goodsVos = goodsService.pageGoodsBase(goodsVo, page, num);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("page", goodsVos);
        CommonResponse success = CommonResponse.success(resultMap);
        return success;

    }

}
