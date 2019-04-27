package com.achan.entity.base;

import java.math.BigDecimal;

public class GoodsBase {
    private String id;

    private String number;

    private String name;

    private String typeId;

    private String majorUnitId;

    private String auxiliaryUnitId;

    private BigDecimal unitRate;

    private BigDecimal inPrice;

    private BigDecimal outPrice;

    private String manufacturer;

    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getMajorUnitId() {
        return majorUnitId;
    }

    public void setMajorUnitId(String majorUnitId) {
        this.majorUnitId = majorUnitId == null ? null : majorUnitId.trim();
    }

    public String getAuxiliaryUnitId() {
        return auxiliaryUnitId;
    }

    public void setAuxiliaryUnitId(String auxiliaryUnitId) {
        this.auxiliaryUnitId = auxiliaryUnitId == null ? null : auxiliaryUnitId.trim();
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    public BigDecimal getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(BigDecimal outPrice) {
        this.outPrice = outPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}