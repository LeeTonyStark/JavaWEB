package com.web;

import com.pojo.Goods;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品详情servlet
 * @author lifeng
 * @create 2022-09-27 0:54
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id请求参数
        String gid = req.getParameter("gid");

        //调用数据库查询数据
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.findAllGoodsById(gid);

        //放在request域中
        req.setAttribute("detailGoods",goods);

        //转发到商品详情页
        req.getRequestDispatcher("/pages/detail.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
