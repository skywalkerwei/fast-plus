package com.imguo.model.mall.domain;

import java.io.Serializable;

/**
 * 商城-分类
 * @TableName mall_category
 */
public class MallCategory implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 商户id
     */
    private Integer mid;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 副标题
     */
    private String title;

    /**
     * 图片
     */
    private String image;

    /**
     * 状态1正常 0禁用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer weight;

    /**
     * 
     */
    private Long createdAt;

    /**
     * 
     */
    private Long updatedAt;

    /**
     * 
     */
    private Long deletedAt;

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商户id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 商户id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 副标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 副标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 状态1正常 0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态1正常 0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 排序
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 排序
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     */
    public Long getDeletedAt() {
        return deletedAt;
    }

    /**
     * 
     */
    public void setDeletedAt(Long deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MallCategory other = (MallCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mid=").append(mid);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", title=").append(title);
        sb.append(", image=").append(image);
        sb.append(", status=").append(status);
        sb.append(", weight=").append(weight);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}