package com.ffcs.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品所属种类表
 * Created by hemb on 2020/8/5.
 */
@Entity
@Table(name = "goods_type")
public class GoodsType implements Serializable {
    private static final long serialVersionUID = 372937498845022449L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "type_id")
    private Integer id;

    @Column(name = "type_name")
    private String name;

    @Column(name = "opr_id")
    private Integer operId;

    @Column(name = "opr_date")
    private Date operDate;

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
}
