package com.ffcs.demo.service;

import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.entity.OrderGoods;
import com.ffcs.demo.req.CartReq;

import java.util.List;
import java.util.Map;

public interface OrderGoodsService {
    List<Map<String,Object>> query(OrderGoods orderGoods);

    int add(OrderGoods orderGoods);

    int del(Integer orderGoodsId);

    int update(OrderGoods orderGoods);
}
