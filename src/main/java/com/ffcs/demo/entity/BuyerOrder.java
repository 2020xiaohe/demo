/**
 * BuyerOrder.java	  V1.0   2020年9月12日 下午3:04:40
 *
 * Copyright 2020 FUJIAN FUJITSU COMMUNICATION SOFTWARE CO., LTD. All rights reserved.
 *
 * Modification history(By    Time    Reason):
 * 
 * Description:
 */

package com.ffcs.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class BuyerOrder {
	
	private Integer orderId;

    private String orderNo;

    private Integer orderStatus;

    private String StatusDesc;

    private BigDecimal price;

    private String address;

    private String lat;

    private String lng;

    private Date createTime;

    private String remark;
    
    private String goodsName;
    
    private String goodsDetail;
    
    private BigDecimal goodsPrice;
    
    private String goodsPic;
    
    private BigDecimal goodsPerPrice;
    
    private BigDecimal goodesTotalPrice;
    

}
