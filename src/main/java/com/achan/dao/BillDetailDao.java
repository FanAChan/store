package com.achan.dao;

import com.achan.dao.base.BillDetailBaseMapper;
import com.achan.entity.BillDetailVo;
import com.achan.entity.base.BillDetailBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillDetailDao extends BillDetailBaseMapper {

    int batchInsert(@Param("list") List<BillDetailVo> list);

    int deleteByBillId(@Param("bill_id") String id);

}
