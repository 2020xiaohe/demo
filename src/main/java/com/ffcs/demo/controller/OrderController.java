package com.ffcs.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.ffcs.demo.constant.OperResult;
import com.ffcs.demo.domain.AlipayBean;
import com.ffcs.demo.entity.*;
import com.ffcs.demo.req.AlipayReq;
import com.ffcs.demo.req.OrderReq;
import com.ffcs.demo.service.*;
import com.ffcs.demo.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private AlipayService alipayService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @PostMapping("/alipay")//付款
    public String alipay(@RequestBody AlipayReq alipayReq) throws AlipayApiException {

        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(alipayReq.getOut_trade_no());
        alipayBean.setSubject(alipayReq.getSubject());
        alipayBean.setTotal_amount(alipayReq.getTotal_amount());
        alipayBean.setBody(alipayReq.getBody());
        //清除购物车信息
        this.delCartGoods(alipayReq.getCartList());
        return alipayService.alipay(alipayBean);
    }

    @PostMapping("/refund")//整个订单退款
    public String refund(@RequestBody AlipayReq alipayReq) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(alipayReq.getOut_trade_no());
        alipayBean.setSubject(alipayReq.getSubject());
        alipayBean.setTotal_amount(alipayReq.getTotal_amount());
        alipayBean.setBody(alipayReq.getBody());
        return alipayService.refund(alipayBean);
    }

    @PostMapping("/update")
    public int update(@RequestBody Order order) {
        int success = 0;
        success = orderService.update(order);
        return success;
    }

    @PostMapping("/add")
    public String add(@RequestBody OrderReq orderReq) {
        //添加订单表
        //订单号
        System.out.println(orderReq);
        long orderCode = System.currentTimeMillis();
        String orderNo = Long.toString(orderCode) + orderReq.getUserId();
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setBuyerId(orderReq.getUserId());
        order.setPrice(orderReq.getAllPrice());
        order.setRemark(orderReq.getRemark());
        order.setOrderStatus(0);//订单状态 0待付款 1 为进行中，2 为取消，3 为完成 4 退款中 5 退款失败 6 退款完成
        List<OrderGoods> orderList = orderReq.getOrderList();
        int result = orderService.add(order);
        if (result > 0) {
            //订单商品添加
            for (OrderGoods orderGoods : orderList) {
                BigDecimal goodsTotalPrice = orderGoods.getGoodsPerPrice().multiply(new BigDecimal(orderGoods.getGoodsCount()));
                orderGoods.setGoodesTotalPrice(goodsTotalPrice);
                orderGoods.setOrderNo(orderNo);
                orderGoodsService.add(orderGoods);
            }
        }
        return orderNo;
    }


    @PostMapping("/query")
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

    /**
     * 查询所有订单--分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getPageAllOrderInfo")
    @ResponseBody
    public String getPageAllOrder(int pageNum, int pageSize) {
        JSONObject json = new JSONObject();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orderService.getAll());
        for (Order g : pageInfo.getList()) {
            switch (g.getOrderStatus()) {
                case 1: {
                    g.setStatusDesc("进行中");
                    break;
                }
                case 2: {
                    g.setStatusDesc("取消");
                    break;
                }
                case 3: {
                    g.setStatusDesc("完成");
                    break;
                }
                case 4: {
                    g.setStatusDesc("退款中");
                    break;
                }
                case 5: {
                    g.setStatusDesc("退款失败");
                    break;
                }

            }
        }
        json.put("ordersInfo", pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY, OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }

    /**
     * 查询所有订单--分页--客户端
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getPageAllFinishedOrderInfo")
    @ResponseBody
    public String getPageAllOrderClient(int pageNum, int pageSize) {
        JSONObject json = new JSONObject();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orderService.getAllFinished());
        for (Order g : pageInfo.getList()) {
            g.setStatusDesc("完成");
        }
        json.put("ordersInfo", pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY, OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }

    @GetMapping("/getOrderGoods")
    @ResponseBody
    public String getOrderGoods(int orderNo) {
        JSONObject json = new JSONObject();
        List<OrderGoods> orderGoods = orderService.getOrderGoods(orderNo);
        json.put("orderGoods", orderGoods);
        json.put(OperResult.OPERATION_RESULT_KEY, OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }

    /**
     * 分页查询个人订单
     *
     * @param pageNum
     * @param pageSize
     * @param buyerId
     * @return
     */
    @RequestMapping("/getPageOrderByBuyerId")
    @ResponseBody
    public String getPageOrderByBuyerId(int pageNum, int pageSize, int buyerId) {
        JSONObject json = new JSONObject();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BuyerOrder> pageInfo = new PageInfo<>(orderService.getByBuyerId(buyerId));
        for (BuyerOrder g : pageInfo.getList()) {
            switch (g.getOrderStatus()) {
                case 1: {
                    g.setStatusDesc("进行中");
                    break;
                }
                case 2: {
                    g.setStatusDesc("取消");
                    break;
                }
                case 3: {
                    g.setStatusDesc("完成");
                    break;
                }
                case 4: {
                    g.setStatusDesc("退款中");
                    break;
                }
                case 5: {
                    g.setStatusDesc("退款失败");
                    break;
                }

            }
        }
        json.put("ordersInfo", pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY, OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }

    @GetMapping("/orderStatisticsByDate")
    public String orderStatisticsByDate(String time) throws Exception {
        JSONObject json = new JSONObject();
//        String str = DateUtil.getDateString(time , DateUtil.DATE_FORMAT);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
//        Date date = simpleDateFormat.parse(time);
        List<DayOrderStatistics>  dayOrderStatistics=orderService.getOrderStatisticsByDate(time);
        json.put("dayOrderStatistics", dayOrderStatistics);
        json.put(OperResult.OPERATION_RESULT_KEY, OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return json.toJSONString();
    }
}


