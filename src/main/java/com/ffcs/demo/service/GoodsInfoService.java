package com.ffcs.demo.service;

import com.ffcs.demo.dao.GoodsInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hemb on 2020/8/2.
 */
@Service
public class GoodsInfoService {

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    public GoodsInfoDao getGoodsInfoDao() {
        return goodsInfoDao;
    }
}
