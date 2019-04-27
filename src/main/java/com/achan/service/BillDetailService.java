package com.achan.service;

import com.achan.entity.BillDetailVo;

import java.util.List;

/**
 * @author AChan
 * @title: BillDetailService
 * @description: TODO
 * @date 2019/4/16
 */
public interface BillDetailService {

    int batchInsert(List<BillDetailVo> billDetailVoList);

    int batchDelete(List<String> idList);

    int update(String billId, List<BillDetailVo> billDetailVoList);
}
