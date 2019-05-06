package com.achan.entity;

import com.achan.entity.base.UserBase;

import java.util.List;

/**
 * UserVo
 *
 * @author AChan
 * @date 2019/4/10
 */
public class UserVo extends UserBase {

    private List<RoleVo> roles;

    private List<MenuVo> menuVos;

    private List<PermissionVo> permissionVos;

    private List<StorehouseVo> storehouseVos;

    public List<StorehouseVo> getStorehouseVos() {
        return storehouseVos;
    }

    public void setStorehouseVos(List<StorehouseVo> storehouseVos) {
        this.storehouseVos = storehouseVos;
    }

    public List<MenuVo> getMenuVos() {
        return menuVos;
    }

    public void setMenuVos(List<MenuVo> menuVos) {
        this.menuVos = menuVos;
    }

    public List<PermissionVo> getPermissionVos() {
        return permissionVos;
    }

    public void setPermissionVos(List<PermissionVo> permissionVos) {
        this.permissionVos = permissionVos;
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }
}
