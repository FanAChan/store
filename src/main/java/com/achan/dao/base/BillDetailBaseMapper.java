package com.achan.dao.base;

import com.achan.entity.base.BillDetailBase;
import com.achan.entity.base.BillDetailBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillDetailBaseMapper {
    int countByExample(BillDetailBaseExample example);

    int deleteByExample(BillDetailBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(BillDetailBase record);

    int insertSelective(BillDetailBase record);

    List<BillDetailBase> selectByExample(BillDetailBaseExample example);

    BillDetailBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BillDetailBase record, @Param("example") BillDetailBaseExample example);

    int updateByExample(@Param("record") BillDetailBase record, @Param("example") BillDetailBaseExample example);

    int updateByPrimaryKeySelective(BillDetailBase record);

    int updateByPrimaryKey(BillDetailBase record);
}