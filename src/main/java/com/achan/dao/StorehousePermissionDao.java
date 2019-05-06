package com.achan.dao;

import com.achan.dao.base.StorehousePermissionBaseMapper;
import com.achan.entity.StorehousePermissionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StorehousePermissionDao extends StorehousePermissionBaseMapper {

    List<String> selectByUserId(@Param("id") String id);

    int batchInsert(@Param("list") List<StorehousePermissionVo> storehousePermissionVos);

    int deleteByUserId(@Param("userId") String id);

}
