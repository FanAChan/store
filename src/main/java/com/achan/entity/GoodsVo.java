package com.achan.entity;

import com.achan.entity.base.GoodsBase;

public class GoodsVo extends GoodsBase {

    private String goodsType;

    private String majorUnit;

    private String auxiliaryUnit;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getMajorUnit() {
        return majorUnit;
    }

    public void setMajorUnit(String majorUnit) {
        this.majorUnit = majorUnit;
    }

    public String getAuxiliaryUnit() {
        return auxiliaryUnit;
    }

    public void setAuxiliaryUnit(String auxiliaryUnit) {
        this.auxiliaryUnit = auxiliaryUnit;
    }
}
