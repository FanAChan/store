package com.achan.dao;

import com.achan.dao.base.UnitBaseMapper;
import com.achan.entity.UnitVo;

import java.util.List;

public interface UnitDao extends UnitBaseMapper {

    List<UnitVo> selectByVo(UnitVo unitVo);

}
