package com.web;

import com.pojo.Order;
import com.pojo.User;
import com.service.impl.PersonalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-29 21:45
 */
@WebServlet("/ShowPersonal")
public class ShowPersonal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户是否登录
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            resp.sendRedirect("/pages/index.jsp");
        }
        //获取session中的
        int id = user.getId();
        //调用service，根据用户id查询用户列表
        PersonalServiceImpl personalService = new PersonalServiceImpl();
        List<Order> orderList = personalService.findAllOrder(String.valueOf(id));
        session.setAttribute("personalOrderList",orderList);

        System.out.println(orderList);


        //重定向到personal.jsp
        resp.sendRedirect("/pages/personal.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
