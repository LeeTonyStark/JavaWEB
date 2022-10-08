package com.web;

import com.pojo.Order;
import com.service.impl.PersonalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-30 9:16
 */
@WebServlet("/PersonalOrderDetailServlet")
public class PersonalOrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单id
        String id = req.getParameter("id");
        //根据id查询出某一个订单项
        PersonalServiceImpl personalService = new PersonalServiceImpl();
        Order oneOrderById = personalService.findOneOrderById(id);
        HttpSession session = req.getSession();
        session.setAttribute("oneOrderByOrderId",oneOrderById);
        //重定向到personal_order_detail.jsp
        resp.sendRedirect("/pages/personal_order_detail.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
