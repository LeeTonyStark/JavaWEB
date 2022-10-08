package com.web;

import com.pojo.Cart;
import com.pojo.Goods;
import com.pojo.User;
import com.service.impl.CartServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * 查看购物车
 * @author lifeng
 * @create 2022-09-27 17:22
 */
@WebServlet("/LookCartServlet")
public class LookCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断用户是否登录
        if (req.getSession().getAttribute("user") == null){
            //重定向到首页
            resp.sendRedirect("/pages/index.jsp");
        }

        //从session域对象中获取得到用户id
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserServiceImpl userService = new UserServiceImpl();

        if (username != null){
            User user = userService.FindUserByUsername(username);
            //调用service层先查询出购物车列表
            CartServiceImpl cartService = new CartServiceImpl();
            List<Cart> list = cartService.selectGoodsByid(user.getId());

            BigDecimal sumprice = new BigDecimal("0");

            for (Cart cart : list) {
                Goods goods = cart.getGoods();
                BigDecimal salesprice = goods.getSalesprice();
                BigDecimal nums = cart.getNums();
                salesprice = salesprice.multiply(nums);
                BigDecimal add = sumprice.add(salesprice);
                sumprice = add;
            }


            //将数据装到request域中
            session.setAttribute("cartList",list);

            //将商品总和也放到request域中
            session.setAttribute("sumprice",sumprice);

            req.getRequestDispatcher("/pages/cart.jsp").forward(req,resp);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
