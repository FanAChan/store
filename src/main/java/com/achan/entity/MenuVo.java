package com.achan.entity;

import com.achan.entity.base.MenuBase;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuVo
 *
 * @author AChan
 * @date 2019/4/10
 */
public class MenuVo extends MenuBase {

    private List<PermissionVo> permissions;

    public void addPermissionVo(PermissionVo permissionVo) {
        if (permissions == null) {
            permissions = new ArrayList<>(4);
        }
        permissions.add(permissionVo);
    }

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }
}
