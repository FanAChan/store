package com.achan.entity;

import com.achan.entity.base.MenuBase;

import java.util.List;

/**
 * MenuVo
 * @author AChan
 * @date 2019/4/10
 */
public class MenuVo extends MenuBase {

    private List<PermissionVo> permissions;

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }
}
