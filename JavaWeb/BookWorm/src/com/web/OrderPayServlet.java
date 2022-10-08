package com.web;

import com.alipay.api.AlipayClient;
import com.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author lifeng
 * @create 2022-09-29 20:41
 */
@WebServlet("/OrderPayServlet")
public class OrderPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求参数
        String wiDout_trade_no = request.getParameter("WIDout_trade_no");
        String wiDtotal_amount = request.getParameter("WIDtotal_amount");
        //将其放到域对象中
        Order order = new Order();
        order.setOrderno(wiDout_trade_no);
        order.setMoney(new BigDecimal(wiDtotal_amount));
        System.out.println(order);
        request.setAttribute("payOrder",order);
        request.getRequestDispatcher("/alipay/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
