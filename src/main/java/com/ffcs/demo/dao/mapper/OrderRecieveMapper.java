package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.OrderRecieve;

public interface OrderRecieveMapper {
    int deleteByPrimaryKey(Integer orderRecieveId);

    int insert(OrderRecieve record);

    int insertSelective(OrderRecieve record);

    OrderRecieve selectByPrimaryKey(Integer orderRecieveId);

    int updateByPrimaryKeySelective(OrderRecieve record);

    int updateByPrimaryKey(OrderRecieve record);
}