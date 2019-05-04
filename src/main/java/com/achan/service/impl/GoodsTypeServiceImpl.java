package com.achan.service.impl;

import com.achan.dao.GoodsTypeDao;
import com.achan.entity.GoodsTypeVo;
import com.achan.entity.base.GoodsTypeBase;
import com.achan.entity.base.GoodsTypeBaseExample;
import com.achan.service.GoodsTypeService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author AChan
 * @title: GoodsTypeServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("goodsTypeServiceImpl")
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private static final int NAME_LENGTH = 64;

    private static final int DESCRIPTION_LENGTH = 128;

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public int add(GoodsTypeVo goodsTypeVo) {
        if (checkNameExit(goodsTypeVo)) {
            return 0;
        }
        goodsTypeVo.setDeleted(false);
        return goodsTypeDao.insert(goodsTypeVo);
    }

    @Override
    public int delete(String id) {
        GoodsTypeBase goodsTypeBase = new GoodsTypeBase();
        goodsTypeBase.setId(id);
        goodsTypeBase.setDeleted(true);
        int i = goodsTypeDao.updateByPrimaryKeySelective(goodsTypeBase);
        return i;
    }

    @Override
    public int update(GoodsTypeVo goodsTypeVo) {
        if (checkNameExit(goodsTypeVo)) {
            return 0;
        }
        goodsTypeVo.setDeleted(false);
        return goodsTypeDao.updateByPrimaryKey(goodsTypeVo);
    }

    @Override
    public PageInfo getGoodsTypePage(GoodsTypeVo goodsTypeVo, int page, int num) {
        PageHelper.startPage(page, num);
        GoodsTypeBaseExample goodsTypeBaseExample = new GoodsTypeBaseExample();
        goodsTypeBaseExample.createCriteria()
                .andDeletedEqualTo(false);
        if (!ObjectUtils.isEmpty(goodsTypeVo)) {

        }
        List<GoodsTypeBase> goodsTypeBases = goodsTypeDao.selectByExample(goodsTypeBaseExample);
        List<GoodsTypeVo> goodsTypeVoList = EntityConverter.convert(goodsTypeBases, GoodsTypeVo.class);
        PageInfo goodsTypeBasePageInfo = new PageInfo<>(goodsTypeBases);
        goodsTypeBasePageInfo.setList(goodsTypeVoList);
        return goodsTypeBasePageInfo;
    }

    @Override
    public GoodsTypeVo getById(String id) {
        GoodsTypeBase goodsTypeBase = goodsTypeDao.selectByPrimaryKey(id);
        GoodsTypeVo goodsTypeVo = EntityConverter.convert(goodsTypeBase, GoodsTypeVo.class);
        return goodsTypeVo;
    }

    @Override
    public List<GoodsTypeVo> getAll() {
        GoodsTypeBaseExample goodsTypeBaseExample = new GoodsTypeBaseExample();
        goodsTypeBaseExample.createCriteria()
                .andDeletedEqualTo(false);
        List<GoodsTypeBase> goodsTypeBases = goodsTypeDao.selectByExample(goodsTypeBaseExample);
        List<GoodsTypeVo> goodsTypeVoList = EntityConverter.convert(goodsTypeBases, GoodsTypeVo.class);
        Map<String, GoodsTypeVo> typeVoMap = goodsTypeVoList.stream().collect(Collectors.toMap(GoodsTypeBase::getId, Function.identity()));
        goodsTypeVoList.stream()
                .forEach(goodsTypeVo -> {
                    if (!StringUtils.isEmpty(goodsTypeVo.getParentId())) {
                        typeVoMap.get(goodsTypeVo.getParentId()).addChildren(goodsTypeVo);
                    }
                });
        List<GoodsTypeVo> result = goodsTypeVoList.stream().filter(goodsTypeVo -> {
            return StringUtils.isEmpty(goodsTypeVo.getParentId());
        }).collect(Collectors.toList());
        return result;
    }

    /**
     * 判断类型是否存在，true存在，false不存在
     *
     * @param goodsTypeVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/19 20:39
     **/
    private boolean checkNameExit(GoodsTypeVo goodsTypeVo) {
        GoodsTypeBaseExample goodsTypeBaseExample = new GoodsTypeBaseExample();
        goodsTypeBaseExample.createCriteria()
                .andIdNotEqualTo(goodsTypeVo.getId())
                .andNameEqualTo(goodsTypeVo.getName())
                .andDeletedEqualTo(false);
        List<GoodsTypeBase> goodsTypeBases = goodsTypeDao.selectByExample(goodsTypeBaseExample);

        return !CollectionUtils.isEmpty(goodsTypeBases);
    }

    /**
     * 校验
     *
     * @param goodsTypeVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/19 20:38
     **/
    private boolean validVo(GoodsTypeVo goodsTypeVo) {
        if (ObjectUtils.isEmpty(goodsTypeVo)) {
            return false;
        }
        String name = goodsTypeVo.getName();
        if (StringUtils.isEmpty(name) || name.length() > NAME_LENGTH) {
            return false;
        }
        String description = goodsTypeVo.getDescription();
        if (StringUtils.isEmpty(description) || description.length() > DESCRIPTION_LENGTH) {
            return false;
        }
        String parentId = goodsTypeVo.getParentId();
        if (!StringUtils.isEmpty(parentId)) {
            GoodsTypeBase goodsTypeBase = goodsTypeDao.selectByPrimaryKey(parentId);
            if (ObjectUtils.isEmpty(goodsTypeBase) || goodsTypeBase.getLeaf()) {
                return false;
            }
        }
        return false;
    }

}

