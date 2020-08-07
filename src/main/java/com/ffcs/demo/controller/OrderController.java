package com.ffcs.demo.controller;

import com.alipay.api.AlipayApiException;
import com.ffcs.demo.domain.AlipayBean;
import com.ffcs.demo.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AlipayService alipayService;

    @RequestMapping("/alipay")//付款
    @ResponseBody
    public String alipay(HttpServletRequest req) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(req.getParameter("outTradeNo"));
        alipayBean.setSubject(req.getParameter("subject"));
        alipayBean.setTotal_amount(req.getParameter("totalAmount"));
        alipayBean.setBody(req.getParameter("body"));
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
}


