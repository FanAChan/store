package com.achan.entity.base;

import java.math.BigDecimal;
import java.util.Date;

public class BillBase {
    private String id;

    private String number;

    private String name;

    private Boolean outIn;

    private String outInTypeId;

    private Integer count;

    private BigDecimal totalPrice;

    private Date updatetime;

    private String updateuser;

    private String storehouseId;

    private String fromTo;

    private Date applytime;

    private String applyUserId;

    private Byte state;

    private String remark;

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

    public Boolean getOutIn() {
        return outIn;
    }

    public void setOutIn(Boolean outIn) {
        this.outIn = outIn;
    }

    public String getOutInTypeId() {
        return outInTypeId;
    }

    public void setOutInTypeId(String outInTypeId) {
        this.outInTypeId = outInTypeId == null ? null : outInTypeId.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public String getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(String storehouseId) {
        this.storehouseId = storehouseId == null ? null : storehouseId.trim();
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo == null ? null : fromTo.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}