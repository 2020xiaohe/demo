package com.ffcs.demo.service;

import com.ffcs.demo.entity.Cart;

import java.util.List;
import java.util.Map;


public interface CartService {

     List<Cart> query(Cart cart);

     int add(Cart cart);

     int del(Integer cartId);

     int update(Cart cart);
}
