package com.achan.entity;

import com.achan.entity.base.BillBase;

import java.util.List;

public class BillVo extends BillBase {

    private List<BillDetailVo> billDetailVoList;

    public List<BillDetailVo> getBillDetailVoList() {
        return billDetailVoList;
    }

    public void setBillDetailVoList(List<BillDetailVo> billDetailVoList) {
        this.billDetailVoList = billDetailVoList;
    }
}
