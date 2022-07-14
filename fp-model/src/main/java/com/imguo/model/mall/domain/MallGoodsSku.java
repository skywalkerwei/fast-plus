package com.imguo.model.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品sku表
 * @TableName mall_goods_sku
 */
public class MallGoodsSku implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品表的商品ID
     */
    private Integer goodsId;

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    private Object specifications;

    /**
     * 规格
     */
    private String specStr;

    /**
     * 商品货品价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 商品货品图片
     */
    private String pic;

    /**
     * 状态 0=下架,1=上架
     */
    private Integer status;

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
     * 商品表的商品ID
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 商品表的商品ID
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    public Object getSpecifications() {
        return specifications;
    }

    /**
     * 商品规格值列表，采用JSON数组格式
     */
    public void setSpecifications(Object specifications) {
        this.specifications = specifications;
    }

    /**
     * 规格
     */
    public String getSpecStr() {
        return specStr;
    }

    /**
     * 规格
     */
    public void setSpecStr(String specStr) {
        this.specStr = specStr;
    }

    /**
     * 商品货品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 商品货品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 商品货品图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 商品货品图片
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 状态 0=下架,1=上架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0=下架,1=上架
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        MallGoodsSku other = (MallGoodsSku) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getSpecifications() == null ? other.getSpecifications() == null : this.getSpecifications().equals(other.getSpecifications()))
            && (this.getSpecStr() == null ? other.getSpecStr() == null : this.getSpecStr().equals(other.getSpecStr()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getSpecifications() == null) ? 0 : getSpecifications().hashCode());
        result = prime * result + ((getSpecStr() == null) ? 0 : getSpecStr().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", specifications=").append(specifications);
        sb.append(", specStr=").append(specStr);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", pic=").append(pic);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}