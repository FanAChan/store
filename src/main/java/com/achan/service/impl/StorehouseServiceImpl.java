package com.achan.service.impl;

import com.achan.dao.StorehouseDao;
import com.achan.entity.StoreHouseVo;
import com.achan.entity.base.StorehouseBase;
import com.achan.entity.base.StorehouseBaseExample;
import com.achan.service.StorehouseService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author AChan
 * @title: StorehouseServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("storeHouseService")
public class StorehouseServiceImpl implements StorehouseService {

    private static final int NAME_LENGTH = 64;
    private static final int DESCRIPTION_LENGTH = 256;
    private static final int ADDRESS_LENGTH = 256;

    @Autowired
    private StorehouseDao storehouseDao;

    @Override
    public int add(StoreHouseVo storeHouseVo) {
        if (checkNameExit(storeHouseVo)) {
            return 0;
        }
        storeHouseVo.setDeleted(false);
        return storehouseDao.insert(storeHouseVo);
    }

    @Override
    public int update(StoreHouseVo storeHouseVo) {
        if (checkNameExit(storeHouseVo)) {
            return 0;
        }
        storeHouseVo.setDeleted(false);
        return storehouseDao.updateByPrimaryKey(storeHouseVo);
    }

    @Override
    public int delete(String id) {
        StorehouseBase storehouseBase = new StorehouseBase();
        storehouseBase.setId(id);
        storehouseBase.setDeleted(true);
        int i = storehouseDao.updateByPrimaryKeySelective(storehouseBase);
        return i;
    }

    @Override
    public List<StoreHouseVo> getStorehousePage(StoreHouseVo storeHouseVo, int page, int num) {
        PageHelper.startPage(page, num);
        return storehouseDao.selectByVo(storeHouseVo);
    }

    @Override
    public StoreHouseVo getById(String id) {
        StorehouseBase storehouseBase = storehouseDao.selectByPrimaryKey(id);
        StoreHouseVo storeHouseVo = EntityConverter.convert(storehouseBase,StoreHouseVo.class);
        return storeHouseVo;
    }

    /**
     * 校验输入
     *
     * @param storeHouseVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/17 22:58
     **/
    private boolean validVo(StoreHouseVo storeHouseVo) {
        if (ObjectUtils.isEmpty(storeHouseVo)) {
            return false;
        }
        String name = storeHouseVo.getName();
        if (StringUtils.isEmpty(name) || name.length() > NAME_LENGTH) {
            return false;
        }
        String description = storeHouseVo.getDescription();
        if (StringUtils.isEmpty(description) || description.length() > DESCRIPTION_LENGTH) {
            return false;
        }
        String address = storeHouseVo.getAddress();
        if (StringUtils.isEmpty(address) || address.length() > ADDRESS_LENGTH) {
            return false;
        }
        return true;
    }

    /**
     * 判断仓库名称是否存在
     *
     * @param storeHouseVo
     * @return boolean true 存在 false 不存在
     * @Author AChan
     * @Date 2019/4/17 23:05
     **/
    private boolean checkNameExit(StoreHouseVo storeHouseVo) {
        StorehouseBaseExample storehouseBaseExample = new StorehouseBaseExample();
        storehouseBaseExample.createCriteria()
                .andIdNotEqualTo(storeHouseVo.getId())
                .andNameEqualTo(storeHouseVo.getName())
                .andDeletedEqualTo(false);
        List<StorehouseBase> storehouseBases = storehouseDao.selectByExample(storehouseBaseExample);

        if (CollectionUtils.isEmpty(storehouseBases)) {
            return false;
        }
        return true;
    }
}
