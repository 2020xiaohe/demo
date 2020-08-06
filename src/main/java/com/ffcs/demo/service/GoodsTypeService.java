package com.ffcs.demo.service;

import com.ffcs.demo.dao.GoodsTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hemb on 2020/8/5.
 */
@Service
public class GoodsTypeService {

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    public GoodsTypeDao getGoodsTypeDao() {
        return goodsTypeDao;
    }
}
