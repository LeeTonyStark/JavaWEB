package com.service;

import com.pojo.Address;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-28 17:07
 */
public interface AddressService {
    /**
     * 添加地址
     * @param address
     */
    void addAddress(Address address);

    /**
     * 查询出所有的地址
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
