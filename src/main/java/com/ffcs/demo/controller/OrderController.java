package com.ffcs.demo.controller;

import com.alipay.api.AlipayApiException;
import com.ffcs.demo.domain.AlipayBean;
import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.entity.Order;
import com.ffcs.demo.req.AlipayReq;
import com.ffcs.demo.service.AlipayService;
import com.ffcs.demo.service.CartService;
import com.ffcs.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AlipayService alipayService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;
    @RequestMapping("/alipay")//付款
    @ResponseBody
    public String alipay(AlipayReq alipayReq) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(alipayReq.getOut_trade_no());
        alipayBean.setSubject(alipayReq.getSubject());
        alipayBean.setTotal_amount(alipayReq.getTotal_amount());
        alipayBean.setBody(alipayReq.getBody());
        //清除购物车信息
        this.delCartGoods(alipayReq.getCartList());
        return alipayService.alipay(alipayBean);
    }

    @RequestMapping("/refund")//退款
    @ResponseBody
    public String refund(HttpServletRequest req) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(req.getParameter("outTradeNo"));
        alipayBean.setSubject(req.getParameter("subject"));
        alipayBean.setTotal_amount(req.getParameter("totalAmount"));
        alipayBean.setBody(req.getParameter("body"));
        return alipayService.refund(alipayBean);
    }


    @RequestMapping("/query")
    @ResponseBody
    public List<Order> query(Order order) {
        return orderService.select(order);
    }

    /**
     * 清除购物车中结算的商品
     */
    public void delCartGoods(List<Cart> cartList) {
        for (Cart cart : cartList) {
            cartService.del(cart.getCartId());
        }
    }
}


