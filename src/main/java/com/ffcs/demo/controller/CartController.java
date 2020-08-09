package com.ffcs.demo.controller;

import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.req.CartReq;
import com.ffcs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * create by clr on 2020/8/8
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 查询购物车商品
     */
    @PostMapping("/query")
    public List<Map<String,Object>> query(@RequestBody Cart cart) {
        return cartService.query(cart);
    }

    /**
     * 添加购物车商品
     * @param cart
     * @return
     */
    @PostMapping("/add")
    public int add(@RequestBody Cart cart) {
        return cartService.add(cart);
    }

    /**
     * 修改购物车
     *
     * @param cartReq
     * @return
     */
    @PostMapping("/update")
    public int update( @RequestBody CartReq cartReq) {
        return cartService.update(cartReq);
    }

    /**
     * 删除购物车
     *
     * @param cartId
     * @return
     */

    @RequestMapping("/del/{cartId}")
    public int delete(@PathVariable Integer cartId) {
        return cartService.del(cartId);
    }
}
