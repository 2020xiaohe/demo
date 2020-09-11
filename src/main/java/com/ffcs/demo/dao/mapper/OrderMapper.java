package com.ffcs.demo.dao.mapper;

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

    List<Order> getByBuyerId(Integer buyerId);

    @Select("select DATE_FORMAT(t1.create_time, \"%Y-%m-%d\" ) as date,sum(t1.price) as totalprice,count(t1.order_no) as cjOrder\n" +
            "from order_info t1 where 1=1 and t1.order_status=3 and DATE_FORMAT(t1.create_time, \"%Y-%m-%d\"  )=DATE_FORMAT(#{date}, \"%Y-%m-%d\" )\n" +
            "group by  DATE_FORMAT(t1.create_time, \"%Y-%m-%d\")")
    List<DayOrderStatistics> orderStatisticsByDate(String  date);

    List<Order> getAllFinished();
}
