package com.ffcs.demo.service;

import com.ffcs.demo.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public interface CartService {

    public List<Map<String,Object>> query(Integer userId);

    public int add(Cart cart);

    public int del(Integer cartId);

    public int update(Cart cart);
}
