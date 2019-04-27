package com.achan.service;

import com.achan.entity.BillVo;

import java.util.List;

/**
 * @author AChan
 * @title: BillService
 * @description: TODO
 * @date 2019/4/16
 */
public interface BillService {

    int add(BillVo billVo);

    int delete(String id);

    int update(BillVo billVo);

    List<BillVo> getBillVoPage(BillVo billVo, int page, int num);

    BillVo getBillVoDetail(String id);

}
