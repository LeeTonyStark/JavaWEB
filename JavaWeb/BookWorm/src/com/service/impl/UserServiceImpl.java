package com.service.impl;

import com.dao.user.UserDao;
import com.pojo.User;
import com.service.UserService;
import com.util.MailUtils;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author lifeng
 * @create 2022-09-24 9:48
 */
public class UserServiceImpl implements UserService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    UserDao mapper = session.getMapper(UserDao.class);

    @Override
    public User FindUserByUsername(String username) {
        User user = mapper.FindUserByUsername(username);
        return user;
    }

    @Override
    public void addUser(User user) {
        //在插入用户信息之前，要先判断该数据库是否存在该字段
        User user1 = FindUserByUsername(user.getUsername());

        //获取激活码，发送邮件
        String code = user.getCode();


        String text = "<html lang='zh-CN'><head ><meta charset='utf-8'>" +
                "</head><body>"+
                "尊敬的<span font-color:red>" + user.getUsername() + "</span>您好！<br />《BookMorm》提示您：请复制激活码，点击下方链接进行邮箱激活~" +
                "<br />" +
                "http://localhost:8080/pages/emailActivity_1.jsp</body></html><br />温馨提示，请在五分钟内进行激活，激活码为：" + code;
        //发送的邮件信息
        MailUtils.sendMail(user.getEmail(),text,"邮箱激活");

        //如果用户名不存在，可以插入数据库
        if (user1 == null){
            mapper.addUser(user);
            session.commit();
        }
    }

    @Override
    public String findByCode(String code) {

        String byCode = mapper.findByCode(code);

        return byCode;
    }

    @Override
    public void updateByCode(String code) {
        mapper.updateByCode(code);
        session.commit();
        session.close();
    }

    @Override
    public User Login(String username, String password) {
        User user = mapper.Login(username, password);
        return user;
    }
}
