package com.achan.entity;

import com.achan.entity.base.GoodsTypeBase;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsTypeVo extends GoodsTypeBase {

    List<GoodsTypeVo> children;

    public List<GoodsTypeVo> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTypeVo> children) {
        this.children = children;
    }

    public void addChildren(GoodsTypeVo goodsTypeVo) {
        if (null == children) {
            children = new ArrayList<>();
        }
        children.add(goodsTypeVo);
    }
}
