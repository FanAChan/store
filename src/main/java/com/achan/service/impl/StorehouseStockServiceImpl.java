package com.achan.service.impl;

import com.achan.dao.StorehousePermissionDao;
import com.achan.dao.StorehouseStockDao;
import com.achan.entity.StoreHouseStockVo;
import com.achan.service.StorehouseStockService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AChan
 * @title: StorehouseStockServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("storehouseStockService")
public class StorehouseStockServiceImpl implements StorehouseStockService {

    @Autowired
    private StorehouseStockDao storehouseStockDao;

    @Autowired
    private StorehousePermissionDao storehousePermissionDao;

    @Override
    public int add(StoreHouseStockVo storeHouseStockVo) {
        return 0;
    }

    @Override
    public int update(StoreHouseStockVo storeHouseStockVo) {
        return 0;
    }

    @Override
    public List<StoreHouseStockVo> page(String userId, StoreHouseStockVo storeHouseStockVo, int page, int num) {
        List<String> storehouseIdList = new ArrayList<>();
        storehouseIdList = storehousePermissionDao.selectByUserId(userId);
        PageHelper.startPage(page, num);
        String goodsId = null;
        if (storeHouseStockVo != null) {
            goodsId = storeHouseStockVo.getGoodsId();
        }
        List<StoreHouseStockVo> storeHouseStockVos = storehouseStockDao.selectByGoodsIdOrStorehouseId(goodsId,
                storehouseIdList);
        return storeHouseStockVos;
    }
}
