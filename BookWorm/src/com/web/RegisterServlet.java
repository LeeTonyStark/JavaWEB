package com.web;

import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author lifeng
 * @create 2022-09-26 16:45
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，将其封装到bean中
        Map<String, String[]> parameterMap = req.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //随机生成一个激活码
        String code = UUID.randomUUID().toString().replace("-", "");

        //将激活码塞入user对象中
        user.setCode(code);

        user.setStatus("0");

        //访问数据库插入数据
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);

        //重定向到邮箱激活界面
        resp.sendRedirect(req.getContextPath()+"/pages/emailActivity.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
