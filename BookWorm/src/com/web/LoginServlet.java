package com.web;

import com.pojo.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-26 21:51
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用service层
        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.Login(username, password);

        //将用户名存储在session域中
        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        //将用户信息也存储在域对象中
        User user = userService.FindUserByUsername(username);
        session.setAttribute("user",user);

        if (login != null){
            //登陆成功！重定向到首页
            resp.sendRedirect("/pages/index.jsp");
        }else {
            //登录失败!转发到当前页面
            req.getRequestDispatcher("/pages/Login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
