package com.achan.entity.base;

public class MenuBase {
    private String id;

    private String name;

    private String description;

    private String url;

    private String image;

    private Byte seq;

    private Boolean limited;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public Boolean getLimited() {
        return limited;
    }

    public void setLimited(Boolean limited) {
        this.limited = limited;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}