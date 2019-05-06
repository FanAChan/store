package com.achan.dao;

import com.achan.dao.base.PermissionBaseMapper;
import com.achan.entity.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao extends PermissionBaseMapper {

    List<PermissionVo> selectByIds(@Param("ids") List<String> ids);

}
