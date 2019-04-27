package com.achan.dao.base;

import com.achan.entity.base.StorehousePermissionBase;
import com.achan.entity.base.StorehousePermissionBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorehousePermissionBaseMapper {
    int countByExample(StorehousePermissionBaseExample example);

    int deleteByExample(StorehousePermissionBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(StorehousePermissionBase record);

    int insertSelective(StorehousePermissionBase record);

    List<StorehousePermissionBase> selectByExample(StorehousePermissionBaseExample example);

    StorehousePermissionBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StorehousePermissionBase record, @Param("example") StorehousePermissionBaseExample example);

    int updateByExample(@Param("record") StorehousePermissionBase record, @Param("example") StorehousePermissionBaseExample example);

    int updateByPrimaryKeySelective(StorehousePermissionBase record);

    int updateByPrimaryKey(StorehousePermissionBase record);
}