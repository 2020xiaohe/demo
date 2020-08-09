package com.ffcs.demo.service;

import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.req.CartReq;

import java.util.List;
import java.util.Map;


public interface CartService {

     List<Map<String,Object>> query(Cart cart);

     int add(Cart cart);

     int del(Integer cartId);

     int update(CartReq cartReq);
}
