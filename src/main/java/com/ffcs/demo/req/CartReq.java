package com.ffcs.demo.req;

import com.ffcs.demo.entity.Cart;
import lombok.Data;

import java.util.Date;

@Data
public class CartReq {
    private Integer cartId;

    private Integer userId;

    private Integer goodsId;

    private Integer count;

    private Date oprDate;

    int action;//1为+1   2为-1
}
