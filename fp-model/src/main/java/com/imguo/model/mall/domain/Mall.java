package com.imguo.model.mall.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 店铺
 * @TableName mall
 */

public class Mall implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 学校ID
     */
    private Integer universityId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 店铺电话
     */
    private String tel;

    /**
     * 公告
     */
    private String notice;

    /**
     * 配送费
     */
    private BigDecimal distributionFee;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * 
     */
    private LocalDateTime deletedAt;

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
     * 学校ID
     */
    public Integer getUniversityId() {
        return universityId;
    }

    /**
     * 学校ID
     */
    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    /**
     * 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 店铺名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 店铺电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 店铺电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 公告
     */
    public String getNotice() {
        return notice;
    }

    /**
     * 公告
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * 配送费
     */
    public BigDecimal getDistributionFee() {
        return distributionFee;
    }

    /**
     * 配送费
     */
    public void setDistributionFee(BigDecimal distributionFee) {
        this.distributionFee = distributionFee;
    }

    /**
     * 
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     */
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /**
     * 
     */
    public void setDeletedAt(LocalDateTime deletedAt) {
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
        Mall other = (Mall) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUniversityId() == null ? other.getUniversityId() == null : this.getUniversityId().equals(other.getUniversityId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getNotice() == null ? other.getNotice() == null : this.getNotice().equals(other.getNotice()))
            && (this.getDistributionFee() == null ? other.getDistributionFee() == null : this.getDistributionFee().equals(other.getDistributionFee()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUniversityId() == null) ? 0 : getUniversityId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getNotice() == null) ? 0 : getNotice().hashCode());
        result = prime * result + ((getDistributionFee() == null) ? 0 : getDistributionFee().hashCode());
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
        sb.append(", universityId=").append(universityId);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", notice=").append(notice);
        sb.append(", distributionFee=").append(distributionFee);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}