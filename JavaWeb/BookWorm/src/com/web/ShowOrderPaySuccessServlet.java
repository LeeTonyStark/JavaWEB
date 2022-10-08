package com.web;

import com.pojo.Order;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-29 20:47
 */
@WebServlet("/ShowOrderPaySuccessServlet")
public class ShowOrderPaySuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将订单的status设置为1
        HttpSession session = req.getSession();
        Order payOrder = (Order) session.getAttribute("payOrder");

        //将订单信息传入
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.updateOrder(payOrder);

        System.out.println("支付成功！");
        //重定向到首页面
        resp.sendRedirect("/pages/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
