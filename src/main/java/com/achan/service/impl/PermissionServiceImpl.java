package com.achan.service.impl;

import com.achan.dao.MenuDao;
import com.achan.dao.PermissionDao;
import com.achan.entity.MenuVo;
import com.achan.entity.PermissionVo;
import com.achan.entity.base.PermissionBase;
import com.achan.entity.base.PermissionBaseExample;
import com.achan.service.PermissionService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author AChan
 * @title: PermissionServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<PermissionVo> getAllPermission() {
        return null;
    }

    @Override
    public PageInfo getPermissionPage(PermissionVo permissionVo, int page, int num) {
        PageHelper.startPage(page, num);
        PermissionBaseExample example = new PermissionBaseExample();
        example.createCriteria()
                .andDeletedEqualTo(false);
        List<PermissionBase> permissionBases = permissionDao.selectByExample(example);
        PageInfo pageInfo = new PageInfo(permissionBases);
        List<PermissionVo> permissionVoList = EntityConverter.convert(permissionBases, PermissionVo.class);
        List<String> menuIdList = permissionBases.stream().map(PermissionBase::getMenuId).collect(Collectors.toList());
        List<MenuVo> menuVoList = menuDao.selectByIds(menuIdList);
        Map<String, String> menuMap = menuVoList.stream().collect(Collectors.toMap(MenuVo::getId, MenuVo::getName));
        permissionVoList.stream().forEach(vo -> vo.setMenu(menuMap.get(vo.getMenuId())));
        pageInfo.setList(permissionVoList);
        return pageInfo;
    }

    @Override
    public List<PermissionVo> getPermissionByMenu(List<String> menuIdList) {
        return null;
    }
}
