package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.CartMapper;
import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.req.CartReq;
import com.ffcs.demo.service.CartService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
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
    public List<Map<String,Object>> query(Cart cart) {
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
        List<Map<String,Object>> cartList =  cartMapper.select(query);
        System.out.println(cartList);
        int isExist = cartList.size();
        int success=0;
        if(cartList.size()>0)//判断该用户购物车里是否有这个商品，有则数量+1  没有则新增
        {
            Cart updateCart = new Cart();
            updateCart.setCartId((Integer) cartList.get(0).get("cart_id"));
            updateCart.setCount(Integer.parseInt(cartList.get(0).get("count").toString())+1);
            success=cartMapper.updateByPrimaryKeySelective(updateCart);
        }
        else{
            success=cartMapper.insert(cart);
        }
        return success;
    }

    /**
     * 删除购物车商品
     * @param cartId
     * @return
     */
    @Override
    public int del(Integer cartId) {
        return cartMapper.deleteByPrimaryKey(cartId);
    }


    /**
     * 修改购物车信息
     * @param cartReq
     * @return
     */
    @Override
    public int update(CartReq cartReq) {
        Cart updateCart=new Cart();
        BeanUtils.copyProperties(cartReq, updateCart); //把前面对象的属性值给后面对象对应的属性
        int action=cartReq.getAction();
        if(action==1)//+1
        {
            updateCart.setCount(updateCart.getCount()+1);
        }
        else{//-1
            updateCart.setCount(updateCart.getCount()-1);
        }
        return cartMapper.updateByPrimaryKeySelective(updateCart);
    }
}
