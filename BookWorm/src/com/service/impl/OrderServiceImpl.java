package com.service.impl;

import com.dao.order.OrderDao;
import com.pojo.Order;
import com.service.OrderService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author lifeng
 * @create 2022-09-29 14:00
 */
public class OrderServiceImpl implements OrderService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    OrderDao mapper = session.getMapper(OrderDao.class);

    @Override
    public void addOrder(Order order) {
        mapper.addOrder(order);
        session.commit();
        session.close();
    }

    @Override
    public void updateOrder(Order order) {
        mapper.updateOrder(order);
        session.commit();
        session.close();
    }
}
