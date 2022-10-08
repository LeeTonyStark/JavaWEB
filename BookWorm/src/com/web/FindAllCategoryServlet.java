package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Category;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 22:07
 */
@WebServlet("/FindAllCategoryServlet")
public class FindAllCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在数据库查询到所有的种类项
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCateGory = categoryService.findAllCateGory();

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        //将数据以json格式传入到前端js方法中
        ObjectMapper om = new ObjectMapper();
        om.writeValue(resp.getWriter(),allCateGory);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
