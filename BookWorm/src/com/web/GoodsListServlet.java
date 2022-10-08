package com.web;

import com.pojo.PageBean;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-24 14:53
 */
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取图书类别id
        String cid = req.getParameter("cid");
        String pageNo = req.getParameter("pageNo");

        //根据id分类查询所有图书
        GoodsService goodsService = new GoodsServiceImpl();
        PageBean pageBean = goodsService.FindPageById(Integer.parseInt(cid), Integer.parseInt(pageNo));

        //将数据放到session域中，然后转发到商品列表
        HttpSession session = req.getSession();
        session.setAttribute("pageBean",pageBean);

        //转发
        req.getRequestDispatcher("/pages/goods_list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
