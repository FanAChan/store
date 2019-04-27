package com.achan.service.impl;

import com.achan.entity.BillDetailVo;
import com.achan.service.BillDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AChan
 * @title: BillDetailServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("billDetailService")
public class BillDetailServiceImpl implements BillDetailService {
    @Override
    public int batchInsert(List<BillDetailVo> billDetailVoList) {
        return 0;
    }

    @Override
    public int batchDelete(List<String> idList) {
        return 0;
    }

    @Override
    public int update(String billId, List<BillDetailVo> billDetailVoList) {
        return 0;
    }
}
