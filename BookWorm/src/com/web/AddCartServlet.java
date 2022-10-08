package com.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Cart;
import com.pojo.User;
import com.service.impl.CartServiceImpl;
import com.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 加入购物车
 * @author lifeng
 * @create 2022-09-27 12:23
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，封装到对象中
        Map<String, String[]> parameterMap = req.getParameterMap();
        Cart cart = new Cart();

        try {
            BeanUtils.populate(cart,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //获取单价，计算小计
        if (cart.getPrice() != null && cart.getNums() != null){
            BigDecimal sumPrice = new BigDecimal(String.valueOf(cart.getPrice().multiply(cart.getNums())));
            System.out.println("数量*小计="+ cart.getPrice() + "*" + cart.getNums() +sumPrice);
            cart.setPrice(sumPrice);
        }else {
            System.out.println("获取的价格和单价为" + cart.getPrice() + "..." + cart.getNums());
        }

        //获取当前用户id
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        //根据用户名查询用户
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.FindUserByUsername(username);

        if (user != null){
            //将用户id塞到购物车对象中
            cart.setUserid(user.getId());
        }

        //打印测试是否有数据
//        System.out.println("加入购物车之前"+user);
//        System.out.println("加入购物车之前"+cart);

        //设置响应编码
        resp.setContentType("application/json;charset=utf-8");

        //将数据以json格式传入到前端js方法中
        ObjectMapper om = new ObjectMapper();

        //然后调用service接口将数据插入到数据库中
        //判断购物车数据库中是否存在该用户以及该商品
        CartServiceImpl cartService = new CartServiceImpl();
        if (cart.getGoodsid() != 0 && cart.getUserid() != 0){
            Boolean isExist = cartService.selectGoodsAndUser(String.valueOf(cart.getGoodsid()), String.valueOf(cart.getUserid()));
            //如果不存在，直接插入
            if (isExist == null){
                //调用service层插入数据
                cartService.addCart(cart);
                om.writeValue(resp.getWriter(),"加入购物车成功！请点击右边购物车进行查看");
            } else {
                //如果存在，修改商品的数量以及小计
                Cart oldCart = cartService.selectCartByUserid(String.valueOf(user.getId()), String.valueOf(cart.getGoodsid()));
                //获取数据中存在的购物车
                if (oldCart != null){
                    //调用service层修改数据
                    BigDecimal num = cart.getNums().add(oldCart.getNums());
                    BigDecimal pri = cart.getPrice().add(oldCart.getPrice());
                    System.out.println("修改后的商品价格为："+pri + "数量：" + num + "用户id:" + user.getId() + "商品id：" + cart.getGoodsid());
                    cartService.updateCart(pri,num,String.valueOf(user.getId()),String.valueOf(cart.getGoodsid()));
                    om.writeValue(resp.getWriter(),"加入购物车成功！请点击右边购物车进行查看");
                }else {
                    System.out.println("数据库中购物车为空");
                }
            }

        }else {
            om.writeValue(resp.getWriter(),"请先登录~");
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
