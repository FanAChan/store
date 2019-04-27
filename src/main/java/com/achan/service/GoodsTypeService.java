package com.achan.service;

import com.achan.entity.GoodsTypeVo;

import java.util.List;

/**
 * @author AChan
 * @title: GoodsTypeService
 * @description: TODO
 * @date 2019/4/16
 */
public interface GoodsTypeService {

    int add(GoodsTypeVo goodsTypeVo);

    int delete(String id);

    int update(GoodsTypeVo goodsTypeVo);

    List<GoodsTypeVo> getGoodsTypePage(int page, int num);

    GoodsTypeVo getById(String id);
}
