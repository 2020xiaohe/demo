package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.CartMapper;
import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 通过用户id查找该用户购物车信息
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> query(Integer userId) {
        return cartMapper.selectByUserId(userId);
    }

    @Override
    public int add(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public int del(Integer cartId) {
        return cartMapper.deleteByPrimaryKey(cartId);
    }

    @Override
    public int update(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart);
    }
}
