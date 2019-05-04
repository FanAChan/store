package com.achan.service.impl;

import com.achan.dao.MenuDao;
import com.achan.dao.RoleMenuDao;
import com.achan.entity.MenuVo;
import com.achan.entity.base.MenuBase;
import com.achan.entity.base.MenuBaseExample;
import com.achan.entity.base.RoleMenuBase;
import com.achan.entity.base.RoleMenuBaseExample;
import com.achan.service.MenuService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AChan
 * @title: MenuServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public List<MenuVo> getAll() {
        MenuBaseExample menuBaseExample = new MenuBaseExample();
        menuBaseExample.createCriteria()
                .andDeletedEqualTo(false);
        List<MenuBase> menuBases = menuDao.selectByExample(menuBaseExample);
        List<MenuVo> menuVoList = EntityConverter.convert(menuBases, MenuVo.class);
        return menuVoList;
    }

    @Override
    public List<MenuVo> getLimited() {
        MenuBaseExample menuBaseExample = new MenuBaseExample();
        menuBaseExample.createCriteria()
                .andLimitedEqualTo(true)
                .andDeletedEqualTo(false);
        List<MenuBase> menuBases = menuDao.selectByExample(menuBaseExample);
        List<MenuVo> menuVoList = EntityConverter.convert(menuBases, MenuVo.class);
        return menuVoList;
    }

    @Override
    public PageInfo getPage(MenuVo menuVo, int page, int num) {
        PageHelper.startPage(page, num);
        MenuBaseExample menuBaseExample = new MenuBaseExample();
        menuBaseExample.createCriteria()
                .andDeletedEqualTo(false);
        List<MenuBase> menuBases = menuDao.selectByExample(menuBaseExample);
        List<MenuVo> menuVoList = EntityConverter.convert(menuBases, MenuVo.class);
        PageInfo pageInfo = new PageInfo<>(menuBases);
        pageInfo.setList(menuVoList);
        return pageInfo;
    }

    @Override
    public MenuVo getById(String id) {
        MenuBase menuBase = menuDao.selectByPrimaryKey(id);
        MenuVo menuVo = EntityConverter.convert(menuBase, MenuVo.class);
        return menuVo;
    }

    @Override
    public List<String> getByRole(String id) {
        RoleMenuBaseExample roleMenuBaseExample = new RoleMenuBaseExample();
        roleMenuBaseExample.createCriteria()
                .andRoleIdEqualTo(id)
                .andDeletedEqualTo(false);
        List<RoleMenuBase> roleMenuBases = roleMenuDao.selectByExample(roleMenuBaseExample);
        List<String> menuIdList = roleMenuBases.stream()
                .map(RoleMenuBase::getMenuId)
                .collect(Collectors.toList());
        return menuIdList;
    }
}

