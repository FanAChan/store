package com.achan.entity;

import com.achan.entity.base.RoleBase;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * RoleVo
 * @author AChan
 * @date 2019/4/10
 */
public class RoleVo extends RoleBase {

    /**
     * 角色授权菜单
     */
    private List<Menu> menus;

    /**
     * 角色授权菜单下权限，根据菜单隔离
     */
    private Map<String, List<PermissionVo>> menuToPermissions;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Map<String, List<PermissionVo>> getMenuToPermissions() {
        return menuToPermissions;
    }

    public void setMenuToPermissions(Map<String, List<PermissionVo>> menuToPermissions) {
        this.menuToPermissions = menuToPermissions;
    }
}
