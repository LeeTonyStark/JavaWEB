package com.service;

import com.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-29 21:54
 */
public interface PersonalService {
    /**
     * 根据用户id查询订单列表
     * @param userid
     * @return
     */
    List<Order> findAllOrder(String userid);

    /**
     * 根据订单id查询出某一条记录
     * @param orderid
     * @return
     */
    Order findOneOrderById(@Param("orderid") String orderid);
}
