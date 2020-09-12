package com.ffcs.demo.dao.mapper;

import com.ffcs.demo.entity.BuyerOrder;
import com.ffcs.demo.entity.DayOrderStatistics;
import com.ffcs.demo.entity.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Select;
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

    @Select("select oi.order_id as orderId,oi.order_no as orderNo,oi.order_status as orderStatus,\n"+
            "oi.price,oi.address,oi.lat,oi.lng,oi.create_time as createTime,oi.remark,\n"+
            "og.goods_per_price as goodsPerPrice,og.goodes_total_price as goodesTotalPrice,\n"+
            "gi.goods_name as goodsName,gi.goods_detail as goodsDetail,gi.goods_price as goodsPrice,gi.goods_pic as goodsPic\n"+
            "from order_info oi,order_goods og,goods_info gi\n"+
            "where buyer_id = #{buyerId} and oi.order_status != 6 and oi.order_status != 0 and oi.order_no = og.order_no and og.goods_id = gi.goods_id\n"+
            "order by oi.create_time desc")
    List<BuyerOrder> getByBuyerId(Integer buyerId);

    @Select("select DATE_FORMAT(t1.create_time, \"%Y-%m-%d\" ) as date,sum(t1.price) as totalprice,count(t1.order_no) as cjOrder\n" +
            "from order_info t1 where 1=1 and t1.order_status=3 and DATE_FORMAT(t1.create_time, \"%Y-%m-%d\"  )=DATE_FORMAT(#{date}, \"%Y-%m-%d\" )\n" +
            "group by  DATE_FORMAT(t1.create_time, \"%Y-%m-%d\")")
    List<DayOrderStatistics> orderStatisticsByDate(String  date);

    List<Order> getAllFinished();
}
