package com.achan.dao;

import com.achan.dao.base.RoleBaseMapper;
import com.achan.entity.RoleVo;
import com.achan.entity.base.RoleBase;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.List;

public interface RoleDao extends RoleBaseMapper {

    /**
     * 根据id获取角色
     *
     * @param ids
     * @return java.util.List<java.lang.String>
     * @Author AChan
     * @Date 2019/4/11
     **/
    List<RoleVo> selectByRoleIds(@Param("ids") List<String> ids);


    /**
     * 根据Base查询
     *
     * @param roleBase
     * @return java.util.List<com.achan.entity.RoleVo>
     * @Author AChan
     * @Date 2019/4/18 11:40
     **/
//    List<RoleVo> selectByBase(RoleBase roleBase);

}
