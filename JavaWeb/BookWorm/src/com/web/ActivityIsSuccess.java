package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 激活成功界面
 * @author lifeng
 * @create 2022-09-26 19:44
 */
@WebServlet("/ActivityIsSuccess")
public class ActivityIsSuccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取code
        String code = req.getParameter("code");

        //查数据库，code是否一致
        UserServiceImpl userService = new UserServiceImpl();
        String byCode = userService.findByCode(code);

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        //向响应体中写入数据
        ObjectMapper om = new ObjectMapper();

        if (code != null && code.equals(byCode)){
            //激活成功

            //修改数据库中的status字段，将此用户状态设置为激活
            userService.updateByCode(code);

            om.writeValue(resp.getWriter(),true);
        }else {
            //激活失败
            om.writeValue(resp.getWriter(),false);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
