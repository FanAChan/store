package com.achan.service.impl;

import com.achan.dao.GoodsDao;
import com.achan.dao.GoodsTypeDao;
import com.achan.dao.UnitDao;
import com.achan.entity.GoodsTypeVo;
import com.achan.entity.GoodsVo;
import com.achan.entity.base.GoodsBase;
import com.achan.entity.base.GoodsBaseExample;
import com.achan.entity.base.GoodsTypeBase;
import com.achan.entity.base.UnitBase;
import com.achan.service.GoodsService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author AChan
 * @title: GoodsServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private static final int NAME_LENGTH = 64;

    private static final int NUMBER_LENGTH = 64;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public int add(GoodsVo goodsVo) {
        if (checkNameOrNumberExit(goodsVo)) {
            return 0;
        }
        goodsVo.setDeleted(false);
        int insert = goodsDao.insert(goodsVo);
        return insert;
    }

    @Override
    public int delete(String id) {
        GoodsBase goodsBase = new GoodsBase();
        goodsBase.setId(id);
        goodsBase.setDeleted(true);
        int i = goodsDao.updateByPrimaryKeySelective(goodsBase);
        return i;
    }

    @Override
    public int update(GoodsVo goodsVo) {
        if (checkNameOrNumberExit(goodsVo)) {
            return 0;
        }
        goodsVo.setDeleted(false);
        int insert = goodsDao.updateByPrimaryKey(goodsVo);
        return insert;
    }

    @Override
    public PageInfo pageGoodsBase(GoodsVo goodsVo, int page, int num) {
        PageHelper.startPage(page, num);
        GoodsBaseExample goodsBaseExample = new GoodsBaseExample();
        goodsBaseExample.createCriteria()
//                .andNameLike(goodsVo.getName())
                .andDeletedEqualTo(false);
        List<GoodsBase> goodsBases = goodsDao.selectByExample(goodsBaseExample);
        List<GoodsVo> goodsVoList = EntityConverter.convert(goodsBases, GoodsVo.class);
        PageInfo pageInfo = new PageInfo<>(goodsBases);

        Set<String> typeIdSet = new HashSet<>();
        Set<String> unitIdSet = new HashSet<>();

        goodsVoList.stream().forEach(vo -> {
            typeIdSet.add(vo.getTypeId());
            unitIdSet.add(vo.getMajorUnitId());
            unitIdSet.add(vo.getAuxiliaryUnitId());
        });
        List<UnitBase> unitBases = unitDao.selectByIds(new ArrayList<>(unitIdSet));
        Map<String, String> unitNameMap = unitBases.stream().collect(Collectors.toMap(UnitBase::getId, UnitBase::getName));

        List<GoodsTypeBase> goodsTypeBases = goodsTypeDao.selectByIds(new ArrayList<>(typeIdSet));
        Map<String, String> typeNameMap = goodsTypeBases.stream().collect(Collectors.toMap(GoodsTypeBase::getId, GoodsTypeBase::getName));

        goodsVoList.stream().forEach(vo -> {
            vo.setGoodsType(typeNameMap.get(vo.getTypeId()));
            vo.setMajorUnit(unitNameMap.get(vo.getMajorUnitId()));
            vo.setAuxiliaryUnit(unitNameMap.get(vo.getAuxiliaryUnitId()));
        });

        pageInfo.setList(goodsVoList);
        return pageInfo;
    }

    @Override
    public GoodsVo getById(String id) {
        GoodsBase goodsBase = goodsDao.selectByPrimaryKey(id);
        GoodsVo goodsVo = EntityConverter.convert(goodsBase, GoodsVo.class);
        return goodsVo;
    }

    /**
     * 判断商品名称或编码是否存在
     * true 存在，false不存在
     *
     * @param goodsVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/18 20:32
     **/
    private boolean checkNameOrNumberExit(GoodsVo goodsVo) {
        GoodsBaseExample goodsBaseExample = new GoodsBaseExample();

        GoodsBaseExample.Criteria criteria1 = goodsBaseExample.createCriteria();
        criteria1.andNameEqualTo(goodsVo.getName())
                .andDeletedEqualTo(false)
                .andIdNotEqualTo(goodsVo.getId());

        GoodsBaseExample.Criteria criteria2 = goodsBaseExample.createCriteria();
        criteria1.andNumberEqualTo(goodsVo.getNumber())
                .andDeletedEqualTo(false)
                .andIdNotEqualTo(goodsVo.getId());

        goodsBaseExample.or(criteria2);

        List<GoodsBase> goodsBases = goodsDao.selectByExample(goodsBaseExample);
        return !CollectionUtils.isEmpty(goodsBases);

    }

    /**
     * 校验
     *
     * @param goodsVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/18 23:20
     **/
    private boolean validVo(GoodsVo goodsVo) {
        if (ObjectUtils.isEmpty(goodsVo)) {
            return false;
        }
        String name = goodsVo.getName();
        if (StringUtils.isEmpty(name) || name.length() > NAME_LENGTH) {
            return false;
        }
        String number = goodsVo.getNumber();
        if (StringUtils.isEmpty(number) || number.length() > NUMBER_LENGTH) {
            return false;
        }
        String majorUnitId = goodsVo.getMajorUnitId();
        if (StringUtils.isEmpty(majorUnitId) ||
                ObjectUtils.isEmpty(unitDao.selectByPrimaryKey(majorUnitId))) {
            return false;
        }
        BigDecimal unitRate = goodsVo.getUnitRate();
        String auxiliaryUnitId = goodsVo.getAuxiliaryUnitId();
        //辅单位不为空
        if (!StringUtils.isEmpty(auxiliaryUnitId)) {
            //转换率不得为空且辅单位必须存在
            if (ObjectUtils.isEmpty(unitRate)
                    || !ObjectUtils.isEmpty(unitDao.selectByPrimaryKey(majorUnitId))) {
                return false;
            }
        }
        return true;

    }
}
