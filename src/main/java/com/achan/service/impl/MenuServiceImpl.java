package com.achan.service.impl;

import com.achan.dao.MenuDao;
import com.achan.entity.MenuVo;
import com.achan.entity.base.MenuBase;
import com.achan.entity.base.MenuBaseExample;
import com.achan.service.MenuService;
import com.achan.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<MenuVo> getPage(MenuVo menuVo, int page, int num) {
        return null;
    }

    @Override
    public MenuVo getById(String id) {
        MenuBase menuBase = menuDao.selectByPrimaryKey(id);
        MenuVo menuVo = EntityConverter.convert(menuBase, MenuVo.class);
        return menuVo;
    }
}

