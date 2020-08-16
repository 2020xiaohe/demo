package com.ffcs.demo.service.impl;

import com.ffcs.demo.dao.mapper.OrderGoodsMapper;
import com.ffcs.demo.entity.OrderGoods;
import com.ffcs.demo.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Override
    public List<Map<String, Object>> query(OrderGoods orderGoods) {
        return null;
    }

    @Override
    public int add(OrderGoods orderGoods) {
        return orderGoodsMapper.insert(orderGoods);
    }

    @Override
    public int del(Integer orderGoodsId) {
        return 0;
    }

    @Override
    public int update(OrderGoods orderGoods) {
        return 0;
    }
}
