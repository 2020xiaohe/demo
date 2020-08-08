package com.ffcs.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderRecieve {
    private Integer orderRecieveId;

    private String orderNo;

    private Integer receiveUserId;

    private Integer goodsId;

    private BigDecimal totalPrice;

    private Integer status;

    private Integer oprId;

    private Date createDate;

    private Date oprDate;

    public Integer getOrderRecieveId() {
        return orderRecieveId;
    }

    public void setOrderRecieveId(Integer orderRecieveId) {
        this.orderRecieveId = orderRecieveId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getOprDate() {
        return oprDate;
    }

    public void setOprDate(Date oprDate) {
        this.oprDate = oprDate;
    }
}