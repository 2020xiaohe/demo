package com.ffcs.demo.controller;

import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * create by clr on 2020/8/8
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 查询购物车商品
     */
    @RequestMapping("/query")
    @ResponseBody
    public List<Cart> query(Cart cart) {
        return cartService.query(cart);
    }

    /**
     * 添加购物车商品
     *
     * @param cart
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public int add(Cart cart) {
        return cartService.add(cart);
    }

    /**
     * 修改购物车
     *
     * @param cart
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public int update(Cart cart) {
        return cartService.update(cart);
    }

    /**
     * 删除购物车
     *
     * @param cartId
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public int delete(Integer cartId) {
        return cartService.del(cartId);
    }
}
