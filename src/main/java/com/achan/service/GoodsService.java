package com.achan.service;

import com.achan.entity.GoodsVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: GoodsService
 * @description: TODO
 * @date 2019/4/16
 */
public interface GoodsService {

    int add(GoodsVo goodsVo);

    int delete(String id);

    int update(GoodsVo goodsVo);

    PageInfo pageGoodsBase(GoodsVo goodsVo, int page, int num);

    GoodsVo getById(String id);
}
