package com.achan.dao;

import com.achan.dao.base.MenuBaseMapper;
import com.achan.entity.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao extends MenuBaseMapper {

    /**
     * @Author AChan
     * @Description 获取菜单列表
     * @Date 2019/4/12
     * @param ids
     * @return java.util.List<com.achan.entity.MenuVo>
     **/
    List<MenuVo> selectByIds(@Param("ids") List<String> ids);
}
