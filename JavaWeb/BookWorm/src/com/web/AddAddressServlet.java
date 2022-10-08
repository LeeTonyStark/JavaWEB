package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Address;
import com.pojo.User;
import com.service.impl.AddressServiceImpl;
import com.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-09-28 16:27
 */
@WebServlet("/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.FindUserByUsername((String) username);
        Map<String, String[]> parameterMap = req.getParameterMap();
        Address address = new Address();
        try {
            BeanUtils.populate(address,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将用户id设置进去
        address.setUserid(user.getId());
        //调用service插入数据
        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.addAddress(address);

        //TODO 进行默认地址的判断，若不判断，会爆空指针异常或地址数量过多

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(),"成功添加一条地址");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
