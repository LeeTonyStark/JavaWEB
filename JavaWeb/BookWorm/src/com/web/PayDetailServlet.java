package com.web;

import com.pojo.Address;
import com.pojo.User;
import com.service.impl.AddressServiceImpl;

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
 * @create 2022-09-28 22:33
 */
@WebServlet("/PayDetailServlet")
public class PayDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");//获取到用户id
        //根据用户id查询出对应的地址
        AddressServiceImpl addressService = new AddressServiceImpl();
        List<Address> allAddress = addressService.findAllAddress(Integer.parseInt(String.valueOf(userid)));
        //将查询出来的地址项放到域对象中
        HttpSession session = req.getSession();
        session.setAttribute("allAddress",allAddress);


        //转发到订单详情页
        req.getRequestDispatcher("/pages/pay_detail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
