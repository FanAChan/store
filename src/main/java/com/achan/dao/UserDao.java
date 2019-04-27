package com.achan.dao;

import com.achan.dao.base.UserBaseMapper;
import com.achan.entity.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends UserBaseMapper {

    UserVo selectByPhone(@Param("phone") String phone);
}
