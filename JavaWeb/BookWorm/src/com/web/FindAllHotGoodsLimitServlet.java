package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Goods;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-30 10:55
 */
@WebServlet("/FindAllHotGoodsLimitServlet")
public class FindAllHotGoodsLimitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过service查询到最新商品数据
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> hotgoods = goodsService.FindAllHotGoodsLimit();

        System.out.println(hotgoods);

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        //将数据以json格式传入到前端js方法中
        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(),hotgoods);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
