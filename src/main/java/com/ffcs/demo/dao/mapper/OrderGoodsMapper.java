package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.OrderGoods;

public interface OrderGoodsMapper {
    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);
}