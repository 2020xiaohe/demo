package com.ffcs.demo.service;

import com.ffcs.demo.entity.DayOrderStatistics;
import com.ffcs.demo.entity.Order;
import com.ffcs.demo.entity.OrderGoods;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {
    public  int add(Order order);

    public int delete(int order);

    public int update(Order order);

    public List<Order> select(Order order);

    public List<Order> getAll();

    List<OrderGoods> getOrderGoods(int orderNo);

    public  List<Order> getByBuyerId(int buyerId);

    List<DayOrderStatistics>  getOrderStatisticsByDate(Date date);

    public  List<Order> getAllFinished();
}

