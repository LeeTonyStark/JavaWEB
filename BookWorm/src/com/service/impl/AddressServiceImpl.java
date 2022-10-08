package com.service.impl;

import com.dao.address.AddressDao;
import com.pojo.Address;
import com.service.AddressService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-28 17:07
 */
public class AddressServiceImpl implements AddressService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    AddressDao mapper = session.getMapper(AddressDao.class);

    @Override
    public void addAddress(Address address) {
        mapper.addAddress(address);
        session.commit();
        session.close();
    }

    @Override
    public List<Address> findAllAddress(int userid) {
        List<Address> list = mapper.findAllAddress(userid);
        return list;
    }

    @Override
    public Address findTypeAddress(int userid) {
        Address typeAddress = mapper.findTypeAddress(userid);
        return typeAddress;
    }
}
