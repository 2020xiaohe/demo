package com.ffcs.demo.controller;

import com.ffcs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    /**
     * 查询购物车商品
     */
    @RequestMapping("/query")
    @ResponseBody
    public List<Map<String,Object>> query(Integer userId)  {
        System.out.println(userId);
    return cartService.query(userId);
    }

    /**
     * 添加购物车商品
     * @param req
     */
    @RequestMapping("/add")
    @ResponseBody
    public void add(HttpServletRequest req)  {

    }

    /**
     * 修改购物车商品
     * @param req
     */
    @RequestMapping("/update")
    @ResponseBody
    public void update(HttpServletRequest req)  {

    }
    /**
     * 删除购物车商品
     * @param req
     */
    @RequestMapping("/del")
    @ResponseBody
    public void delete(HttpServletRequest req)  {

    }
}
