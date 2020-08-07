package com.ffcs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    /**
     * 查询购物车商品
     * @param req
     */
    @RequestMapping("/query")
    @ResponseBody
    public void query(HttpServletRequest req)  {

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
