package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 获取图片验证码servlet
 * @author lifeng
 * @create 2022-09-26 15:36
 */
@WebServlet("/getCheckCode")
public class GetCheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取验证码session
        HttpSession session = req.getSession();
        Object checkCode = session.getAttribute("checkCode");

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(),checkCode);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
