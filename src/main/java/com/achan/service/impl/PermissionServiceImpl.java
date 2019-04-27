package com.achan.service.impl;

import com.achan.entity.PermissionVo;
import com.achan.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AChan
 * @title: PermissionServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<PermissionVo> getAllPermission() {
        return null;
    }

    @Override
    public List<PermissionVo> getPermissionPage(PermissionVo permissionVo, int page, int num) {
        return null;
    }

    @Override
    public List<PermissionVo> getPermissionByMenu(List<String> menuIdList) {
        return null;
    }
}
