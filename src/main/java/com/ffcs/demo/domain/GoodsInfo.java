package com.ffcs.demo.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hemb on 2020/8/2.
 */
@Entity
@Table(name = "goods_info")
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = -8790219123224176064L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "goods_id")
    private Integer id;

    @Column(name = "goods_name")
    private String name;

    @Column(name = "goods_type")
    private Integer type;

    @Column(name = "category")
    private String category;

    @Column(name = "search_count")
    private Integer searchCount;

    @Column(name = "goods_detail")
    private String detail;

    @Column(name = "goods_price", length=10 ,scale=2)    // length表示长度 ， scale表示小数点后位数
    private BigDecimal money;

    @Column(name = "goods_pic")
    private String  picPath;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private Integer status;

    @Transient
    private String statusDesc;

    @Column(name = "opr_id")
    private Integer operId;

    @Column(name = "opr_date")
    private Date operDate;

    @ManyToOne( cascade = CascadeType.REFRESH)
    @JoinColumn(name = "goods_type",referencedColumnName="type_id" ,insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private GoodsType goodsType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Date getOperDate() {
        return operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                ", searchCount=" + searchCount +
                ", detail=" + detail +
                ", money=" + money +
                ", picPath='" + picPath + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", operId=" + operId +
                ", operDate=" + operDate +
                '}';
    }
}
