package com.ffcs.demo.dao;

import com.ffcs.demo.domain.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hemb on 2020/8/2.
 */
public interface GoodsInfoDao extends JpaRepository<GoodsInfo,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update goods_info  "
            +"set  goods_name=:#{#goodsInfo.name},goods_type=:#{#goodsInfo.type},remark=:#{#goodsInfo.remark},category=:#{#goodsInfo.category}"
            +",search_count=:#{#goodsInfo.searchCount},goods_detail=:#{#goodsInfo.detail},goods_price=:#{#goodsInfo.money} where goods_id=:#{#goodsInfo.id}")
    void updateGoodsInfo(@Param("goodsInfo") GoodsInfo goodsInfo);
}
