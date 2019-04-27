package com.achan.dao.base;

import com.achan.entity.base.BillBase;
import com.achan.entity.base.BillBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillBaseMapper {
    int countByExample(BillBaseExample example);

    int deleteByExample(BillBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(BillBase record);

    int insertSelective(BillBase record);

    List<BillBase> selectByExample(BillBaseExample example);

    BillBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BillBase record, @Param("example") BillBaseExample example);

    int updateByExample(@Param("record") BillBase record, @Param("example") BillBaseExample example);

    int updateByPrimaryKeySelective(BillBase record);

    int updateByPrimaryKey(BillBase record);
}