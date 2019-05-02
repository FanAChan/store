package com.achan.dao;

import com.achan.dao.base.UnitBaseMapper;
import com.achan.entity.UnitVo;
import com.achan.entity.base.UnitBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnitDao extends UnitBaseMapper {

    List<UnitVo> selectByVo(UnitVo unitVo);

    List<UnitBase> selectByIds(@Param("ids") List<String> ids);

}
