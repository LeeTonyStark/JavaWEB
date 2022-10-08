package com.dao.address;

import com.pojo.Address;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-28 17:00
 */
public interface AddressDao {
    /**
     * 添加地址
     * @param address
     */
    void addAddress(Address address);

    /**
     * 根据用户id查询出所有的地址
     * @return
     */
    List<Address> findAllAddress(int userid);

    /**
     * 根据用户id查询出该用户的默认地址
     *
     * @param userid
     * @return
     */
    Address findTypeAddress(int userid);
}
