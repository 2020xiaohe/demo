package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.CartMapper;
import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * create by clr on 2002/8/8
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 查找
     * @param cart
     * @return
     */
    @Override
    public List<Cart> query(Cart cart) {
        System.out.println(cart);
        return cartMapper.select(cart);
    }

    /**
     * 添加购物车商品
     * @param cart
     * @return
     */
    @Override
    public int add(Cart cart) {
        Cart query = new Cart();
        query.setGoodsId(cart.getGoodsId());
        query.setUserId(cart.getUserId());
        int isExist = cartMapper.select(cart).size();
        int success=0;
        if(isExist>0)//判断该用户购物车里是否有这个商品，有则数量+1  没有则新增
        {
            query.setCartId(cart.getCartId());
            query.setCount(cart.getCount()+1);
            success=this.update(cart);
        }
        else{
            success=cartMapper.insert(cart);
        }
        return success;
    }

    /**
     * 删除购物车
     * @param cartId
     * @return
     */
    @Override
    public int del(Integer cartId) {
        return cartMapper.deleteByPrimaryKey(cartId);
    }

    /**
     * 修改购物车信息
     * @param cart
     * @return
     */
    @Override
    public int update(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart);
    }
}
