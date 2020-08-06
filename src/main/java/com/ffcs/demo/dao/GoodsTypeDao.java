package com.ffcs.demo.dao;

import com.ffcs.demo.domain.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hemb on 2020/8/5.
 */
public interface GoodsTypeDao  extends JpaRepository<GoodsType,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "update goods_type  "
                    +"set  type_name=:#{#goodsType.name} where type_id=:#{#goodsType.id}")
    void updataGoodsType(@Param("goodsType") GoodsType goodsType);
}
