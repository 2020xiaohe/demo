package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.OrderGoodsMapper;
import com.ffcs.demo.dao.mapper.OrderMapper;
import com.ffcs.demo.entity.BuyerOrder;
import com.ffcs.demo.entity.DayOrderStatistics;
import com.ffcs.demo.entity.Order;
import com.ffcs.demo.entity.OrderGoods;
import com.ffcs.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderInfoMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    /**
     *
     * 增加订单
     */
    public int add(Order order) {
        return orderInfoMapper.insert(order);
    }

    /**
     * 删除订单
     * @param order
     * @return
     */
    @Override
    public int delete(int order) {
        return orderInfoMapper.deleteByPrimaryKey(order);
    }

    /**
     * 修改订单
     * @param order
     * @return
     */
    @Override
    public int update(Order order) {
        return orderInfoMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 查询订单
     * @param order
     * @return
     */
    @Override
    public List<Order> select(Order order) {
        return orderInfoMapper.select(order);
    }

    @Override
    public List<Order> getAll() {
        return orderInfoMapper.getAll();
    }

    @Override
    public List<OrderGoods> getOrderGoods(int orderNo) {
        return orderGoodsMapper.getOrderGoods(orderNo);
    }

    @Override
    public List<BuyerOrder> getByBuyerId(int buyerId) {
        List<BuyerOrder> list = orderInfoMapper.getByBuyerId(buyerId);
        return list;
    }

    public  List<DayOrderStatistics>  getOrderStatisticsByDate(String date){return  orderInfoMapper.orderStatisticsByDate(date);}

    @Override
    public List<Order> getAllFinished() {
        return orderInfoMapper.getAllFinished();
    }
}
