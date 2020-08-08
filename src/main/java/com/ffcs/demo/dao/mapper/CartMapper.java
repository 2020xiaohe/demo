package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    List<Cart> select(Cart cart);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}