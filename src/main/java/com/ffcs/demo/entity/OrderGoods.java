package com.ffcs.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderGoods {
    private Integer orderGoodsId;

    private String orderNo;

    private Integer goodsId;

    private Integer goodsCount;

    private BigDecimal goodsPerPrice;

    private BigDecimal goodesTotalPrice;

    private String goodsContent;

    private Date createTime;

    private Integer oprId;

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getGoodsPerPrice() {
        return goodsPerPrice;
    }

    public void setGoodsPerPrice(BigDecimal goodsPerPrice) {
        this.goodsPerPrice = goodsPerPrice;
    }

    public BigDecimal getGoodesTotalPrice() {
        return goodesTotalPrice;
    }

    public void setGoodesTotalPrice(BigDecimal goodesTotalPrice) {
        this.goodesTotalPrice = goodesTotalPrice;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent == null ? null : goodsContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }
}