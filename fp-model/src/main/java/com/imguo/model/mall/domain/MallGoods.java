package com.imguo.model.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表
 * @TableName mall_goods
 */
public class MallGoods implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商户ID
     */
    private Integer mid;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品主图
     */
    private String image;

    /**
     * 售卖数量
     */
    private Integer sellNumber;

    /**
     * 临时数据
     */
    private Object sku;

    /**
     * 显示售价-非真实价格
     */
    private BigDecimal showPrice;

    /**
     * 商品描述
     */
    private String describes;

    /**
     * 1正常 0 下架
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
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 商户ID
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 商户ID
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 商品主图
     */
    public String getImage() {
        return image;
    }

    /**
     * 商品主图
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 售卖数量
     */
    public Integer getSellNumber() {
        return sellNumber;
    }

    /**
     * 售卖数量
     */
    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
    }

    /**
     * 临时数据
     */
    public Object getSku() {
        return sku;
    }

    /**
     * 临时数据
     */
    public void setSku(Object sku) {
        this.sku = sku;
    }

    /**
     * 显示售价-非真实价格
     */
    public BigDecimal getShowPrice() {
        return showPrice;
    }

    /**
     * 显示售价-非真实价格
     */
    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
    }

    /**
     * 商品描述
     */
    public String getDescribes() {
        return describes;
    }

    /**
     * 商品描述
     */
    public void setDescribes(String describes) {
        this.describes = describes;
    }

    /**
     * 1正常 0 下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 1正常 0 下架
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
        MallGoods other = (MallGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getSellNumber() == null ? other.getSellNumber() == null : this.getSellNumber().equals(other.getSellNumber()))
            && (this.getSku() == null ? other.getSku() == null : this.getSku().equals(other.getSku()))
            && (this.getShowPrice() == null ? other.getShowPrice() == null : this.getShowPrice().equals(other.getShowPrice()))
            && (this.getDescribes() == null ? other.getDescribes() == null : this.getDescribes().equals(other.getDescribes()))
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
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getSellNumber() == null) ? 0 : getSellNumber().hashCode());
        result = prime * result + ((getSku() == null) ? 0 : getSku().hashCode());
        result = prime * result + ((getShowPrice() == null) ? 0 : getShowPrice().hashCode());
        result = prime * result + ((getDescribes() == null) ? 0 : getDescribes().hashCode());
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", image=").append(image);
        sb.append(", sellNumber=").append(sellNumber);
        sb.append(", sku=").append(sku);
        sb.append(", showPrice=").append(showPrice);
        sb.append(", describes=").append(describes);
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