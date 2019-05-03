package com.achan.service;

import com.achan.entity.MenuVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: MenuServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
public interface MenuService {

    List<MenuVo> getAll();

    PageInfo getPage(MenuVo menuVo, int page, int num);

    MenuVo getById(String id);

//    List<MenuVo> getByRoleIdList(List<String> roleIdList);

}
