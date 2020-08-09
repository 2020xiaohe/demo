package com.ffcs.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.ffcs.demo.constant.OperResult;
import com.ffcs.demo.domain.AlipayBean;
import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.entity.Goods;
import com.ffcs.demo.entity.Order;
import com.ffcs.demo.entity.OrderGoods;
import com.ffcs.demo.req.AlipayReq;
import com.ffcs.demo.service.AlipayService;
import com.ffcs.demo.service.CartService;
import com.ffcs.demo.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private AlipayService alipayService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/alipay")//付款
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

    @PostMapping("/refund")//退款
    @ResponseBody
    public String refund(HttpServletRequest req) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(req.getParameter("outTradeNo"));
        alipayBean.setSubject(req.getParameter("subject"));
        alipayBean.setTotal_amount(req.getParameter("totalAmount"));
        alipayBean.setBody(req.getParameter("body"));
        return alipayService.refund(alipayBean);
    }


    @PostMapping("/query")
    @ResponseBody
    public List<Order> query( Order order) {
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

    /**
     * 查询所有订单--分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getPageAllOrderInfo")
    @ResponseBody
    public String getPageAllOrder(int pageNum, int pageSize){
        JSONObject json= new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orderService.getAll());
        for (Order g : pageInfo.getList() ) {
            switch (g.getOrderStatus()){
                case 1:{g.setStatusDesc("进行中"); break;}
                case 2:{g.setStatusDesc("取消");break;}
                case 3:{g.setStatusDesc("完成");break;}
                case 4:{g.setStatusDesc("退款中");break;}
                case 5:{g.setStatusDesc("退款失败");break;}
                case 6:{g.setStatusDesc("退款完成");break;}
            }
        }
        json.put("ordersInfo",pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }

    @GetMapping("/getOrderGoods")
    @ResponseBody
    public String getOrderGoods(int orderNo){
        JSONObject json= new JSONObject();
        List<OrderGoods> orderGoods = orderService.getOrderGoods(orderNo);
        json.put("orderGoods",orderGoods);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }
}


