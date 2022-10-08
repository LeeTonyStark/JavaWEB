package com.web;

import com.pojo.Address;
import com.pojo.Order;
import com.pojo.User;
import com.service.impl.AddressServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author lifeng
 * @create 2022-09-29 13:13
 */
@WebServlet("/OrderInfoServlet")
public class OrderInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断用户是否登录
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            resp.sendRedirect("/pages/index.jsp");
        }

        //用户登录已登录,生成订单编号
        String orderno = UUID.randomUUID().toString().replace("-", "");
        //获取当前系统时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //日期格式格式化为字符串
        String now = sdf.format(date);

        //获取订单总计
        BigDecimal sumprice = (BigDecimal) session.getAttribute("sumprice");
//        根据用户名查询默认地址
        AddressServiceImpl addressService = new AddressServiceImpl();
        Address address = addressService.findTypeAddress(user.getId());


        //将数据塞去Order
        Order order = new Order();
        order.setUserid(user.getId());
        order.setOrderno(orderno);
        order.setOrdertime(now);

        String accept = address.getAccept();//收货人
        String sumaddress = address.getProvince() + address.getCity() + address.getArea() + address.getAddress();//总地址
        String phone = address.getTelphone();

        order.setAccept(accept);
        order.setAddress(sumaddress);
        order.setTelphone(phone);
        order.setMoney(sumprice);
        order.setPaytype("支付宝");
        order.setStatus("0");

//        System.out.println(order);
        //在数据库插入订单信息
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.addOrder(order);

        //将支付订单放到session域中
        session.setAttribute("payOrder",order);

        //重定向到支付界面
        resp.sendRedirect("/pages/order_info.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
