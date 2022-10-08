package com.service.impl;

import com.dao.personal.PersonalDao;
import com.pojo.Order;
import com.service.PersonalService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-29 21:54
 */
public class PersonalServiceImpl implements PersonalService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    PersonalDao mapper = session.getMapper(PersonalDao.class);
    @Override
    public List<Order> findAllOrder(String userid) {
        List<Order> allOrder = mapper.findAllOrder(userid);
        return allOrder;
    }

    @Override
    public Order findOneOrderById(String orderid) {
        Order oneOrderById = mapper.findOneOrderById(orderid);
        return oneOrderById;
    }
}
