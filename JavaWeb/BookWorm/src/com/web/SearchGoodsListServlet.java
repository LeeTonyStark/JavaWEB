package com.web;

import com.github.pagehelper.PageInfo;
import com.pojo.Goods;
import com.service.impl.PageHelperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 使用PageHelper分页插件进行分页模糊搜索
 * @author lifeng
 * @create 2022-09-29 16:32
 */
@WebServlet("/SearchGoodsListServlet")
public class SearchGoodsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //调用数据库分页查询

        //TODO
        PageHelperServiceImpl pageHelperService = new PageHelperServiceImpl();
        List<Goods> list = pageHelperService.PageHelperByGoods(name);
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        req.getSession().setAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        //转发
        req.getRequestDispatcher("/pages/search.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
