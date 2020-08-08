package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.Order;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    List<Order> select(Order order);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getAll();
}
