package com.achan.entity.base;

public class RoleBase {
    private String id;

    private String name;

    private String descriptiontion;

    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescriptiontion() {
        return descriptiontion;
    }

    public void setDescriptiontion(String descriptiontion) {
        this.descriptiontion = descriptiontion == null ? null : descriptiontion.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}