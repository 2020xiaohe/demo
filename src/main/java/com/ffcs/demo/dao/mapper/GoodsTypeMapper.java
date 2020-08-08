package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}