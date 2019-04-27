package com.achan.entity.base;

import java.math.BigDecimal;

public class StorehouseStockBase {
    private String id;

    private String storehouseId;

    private String goodsId;

    private BigDecimal num;

    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(String storehouseId) {
        this.storehouseId = storehouseId == null ? null : storehouseId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}