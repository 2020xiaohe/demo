package com.ffcs.demo.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.demo.entity.Goods;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectALL();
}
