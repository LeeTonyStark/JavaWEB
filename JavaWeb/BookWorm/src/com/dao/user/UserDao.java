package com.dao.user;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author lifeng
 * @create 2022-09-24 9:33
 */
public interface UserDao {
    /**
     * 根据用户名查询一条用户数据
     * @param username
     * @return
     */
    User FindUserByUsername(@Param("username") String username);

    /**
     * 用户注册
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户传入的code查询数据中是否有数据
     * @param code
     * @return
     */
    String findByCode(String code);

    /**
     * 根据激活码修改用户
     * @param code
     */
    void updateByCode(@Param("code") String code);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User Login(@Param("username") String username,@Param("password") String password);

}
