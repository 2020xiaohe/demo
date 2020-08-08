package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.OrderGoods;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer orderGoodsId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}