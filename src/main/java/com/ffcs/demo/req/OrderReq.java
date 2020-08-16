package com.ffcs.demo.req;

import com.ffcs.demo.entity.Order;
import com.ffcs.demo.entity.OrderGoods;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderReq {
   private List<OrderGoods> orderList;

   private Integer userId;

   private BigDecimal allPrice;

   private String remark;

}
