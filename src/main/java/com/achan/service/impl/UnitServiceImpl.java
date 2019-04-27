package com.achan.service.impl;

import com.achan.dao.UnitDao;
import com.achan.entity.UnitVo;
import com.achan.entity.base.UnitBase;
import com.achan.entity.base.UnitBaseExample;
import com.achan.service.UnitService;
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
 * @title: UnitServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Override
    public int add(UnitVo unitVo) {
        if (!validUnit(unitVo) || checkNameExit(unitVo)) {
            return 0;
        }
        unitVo.setDeleted(false);
        return unitDao.insert(unitVo);
    }

    @Override
    public int update(UnitVo unitVo) {
        if (!validUnit(unitVo) || checkNameExit(unitVo)) {
            return 0;
        }
        unitVo.setDeleted(false);
        return unitDao.updateByPrimaryKey(unitVo);
    }

    @Override
    public int delete(String id) {
        UnitBase unitBase = new UnitBase();
        unitBase.setId(id);
        unitBase.setDeleted(true);

        return unitDao.updateByPrimaryKeySelective(unitBase);
    }

    @Override
    public List<UnitVo> pageUnitVo(UnitVo unitVo, int page, int num) {

        PageHelper.startPage(page, num);
        List<UnitVo> unitVos = unitDao.selectByVo(unitVo);
        return unitVos;
    }

    @Override
    public UnitVo getById(String id) {
        UnitBase unitBase = unitDao.selectByPrimaryKey(id);
        UnitVo unitVo = EntityConverter.convert(unitBase, UnitVo.class);
        return unitVo;
    }

    /**
     * 判断是否同名
     *
     * @param unitVo
     * @return boolean true 存在相同，false 不存在相同名称
     * @Author AChan
     * @Date 2019/4/17 22:12
     **/
    private boolean checkNameExit(UnitVo unitVo) {
        UnitBaseExample unitBaseExample = new UnitBaseExample();
        unitBaseExample.createCriteria()
                .andIdNotEqualTo(unitVo.getId())
                .andNameEqualTo(unitVo.getName())
                .andDeletedEqualTo(false);
        List<UnitBase> unitBases = unitDao.selectByExample(unitBaseExample);
        if (CollectionUtils.isEmpty(unitBases)) {
            return false;
        }
        return true;
    }

    /**
     * 校验输入
     *
     * @param unitVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/17 22:16
     **/
    private boolean validUnit(UnitVo unitVo) {
        if (ObjectUtils.isEmpty(unitVo)) {
            return false;
        }
        String name = unitVo.getName();
        if (StringUtils.isEmpty(name) || name.length() > 128) {
            return false;
        }
        String description = unitVo.getDescription();
        if (StringUtils.isEmpty(description) || description.length() > 256) {
            return false;
        }
        return true;
    }
}
