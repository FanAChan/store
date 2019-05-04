package com.achan.service;

import com.achan.entity.PermissionVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: PermissionService
 * @description: TODO
 * @date 2019/4/16
 */
public interface PermissionService {

    List<PermissionVo> getAllPermission();

    PageInfo getPermissionPage(PermissionVo permissionVo, int page, int num);

    List<PermissionVo> getPermissionByMenu(List<String> menuIdList);

}
