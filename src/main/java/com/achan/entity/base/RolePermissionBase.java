package com.achan.entity.base;

public class RolePermissionBase {
    private String id;

    private String roleId;

    private String permissiongId;

    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermissiongId() {
        return permissiongId;
    }

    public void setPermissiongId(String permissiongId) {
        this.permissiongId = permissiongId == null ? null : permissiongId.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}