package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.Cart;
import com.ffcs.demo.entity.GoodsInfo;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    int deleteByPrimaryKey(Integer goodsId);

    List<Map<String,Object>> selectByUserId(Integer userId);

    int insert(Cart record);

    int insertSelective(Cart record);

    GoodsInfo selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

}