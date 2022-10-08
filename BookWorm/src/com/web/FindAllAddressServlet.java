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
 * @create 2022-09-28 19:55
 */
@WebServlet("/FindAllAddressServlet")
public class FindAllAddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端数据
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        AddressServiceImpl addressService = new AddressServiceImpl();
        List<Address> list = addressService.findAllAddress(user.getId());

        //将地址信息存储到域对象中
        session.setAttribute("addresslist",list);
        //转发到收货地址界面
        req.getRequestDispatcher("/pages/personal_address.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
