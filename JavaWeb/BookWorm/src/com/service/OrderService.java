package com.service;

import com.pojo.Order;

/**
 * @author lifeng
 * @create 2022-09-29 13:59
 */
public interface OrderService {
    /**
     * 提交订单后,插入订单
     * @param order
     */
    void addOrder(Order order);

    /**
     * 支付成功后，将订单状态置为1
     * @param order
     */
    void updateOrder(Order order);
}
