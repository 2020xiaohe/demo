package com.ffcs.demo.service;

import java.util.List;

import com.ffcs.demo.dao.GoodsInfoDao;
import com.ffcs.demo.dao.mapper.GoodsMapper;
import com.ffcs.demo.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hemb on 2020/8/2.
 */
@Service
public class GoodsInfoService {

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Autowired
    private GoodsMapper goodsMapper;

    public GoodsInfoDao getGoodsInfoDao() {
        return goodsInfoDao;
    }

    /**
     * 查询所有商品--分页
     * zhuwb 20200808
     * @return
     */
    public List<Goods> getPageALL() {
        return goodsMapper.selectALL();
    }
}
