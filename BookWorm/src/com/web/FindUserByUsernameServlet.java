package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-24 9:28
 */
@WebServlet("/FindUserByUsernameServlet")
public class FindUserByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");

        //与数据库中的数据进行比对查询是否一致
        UserService userService = new UserServiceImpl();
        User user = userService.FindUserByUsername(username);

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        //向响应体中写入数据
        ObjectMapper om = new ObjectMapper();

        if (user == null){
            om.writeValue(resp.getWriter(),"<font style='color: greenyellow;'>用户名可用</font>");
        }else {
            om.writeValue(resp.getWriter(),"<font style='color: red;'>用户名重复,请重新输入</font>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
