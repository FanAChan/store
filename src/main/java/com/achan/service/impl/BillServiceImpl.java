package com.achan.service.impl;

import com.achan.entity.BillVo;
import com.achan.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AChan
 * @title: BillServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("billService")
public class BillServiceImpl implements BillService {
    @Override
    public int add(BillVo billVo) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(BillVo billVo) {
        return 0;
    }

    @Override
    public List<BillVo> getBillVoPage(BillVo billVo, int page, int num) {
        return null;
    }

    @Override
    public BillVo getBillVoDetail(String id) {
        return null;
    }
}
