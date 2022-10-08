package com.test;

import com.pojo.*;
import com.service.GoodsService;
import com.service.impl.*;
import org.junit.Test;
import sun.security.pkcs11.P11Util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 16:39
 */
public class testService {

    @Test
    public void test1(){
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> goods = goodsService.FindAllNewGoodsLimit();
        for (Goods good : goods) {
            System.out.println(good);
        }
    }

    @Test
    public void test2(){
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        List<Category> allCateGory = categoryService.findAllCateGory();
        for (Category category : allCateGory) {
            System.out.println(category);
        }
    }

    @Test
    public void test3(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.FindUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void test4(){
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        PageBean pageBean = goodsService.FindPageById(1, 1);
        System.out.println(pageBean);
    }

    @Test
    public void test5(){
        UserServiceImpl userService = new UserServiceImpl();
        String user = userService.findByCode("51227761ad074e42aeb11aa7f418aa1a");
        System.out.println(user);
    }

    @Test
    public void test6(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.updateByCode("51227761ad074e42aeb11aa7f418aa1a");
    }

    @Test
    public void test7(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.Login("jerry", "123456");
        System.out.println(admin);
    }

    @Test
    public void test8(){
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        Goods list = goodsService.findAllGoodsById("5");
        System.out.println(list);
    }

//    @Test
//    public void test9(){
//        CartServiceImpl cartService = new CartServiceImpl();
//        BigDecimal price = new BigDecimal("67");
//        BigDecimal nums = new BigDecimal("1");
//        Cart cart = new Cart(8,5,4,price,nums);
//        cartService.addCart(cart);
//    }

    @Test
    public void test10(){
        CartServiceImpl cartService = new CartServiceImpl();
        Cart cart = cartService.selectCartByUserid("5", "2");
        System.out.println(cart);
    }

    @Test
    public void test11(){
        CartServiceImpl cartService = new CartServiceImpl();
        Boolean aBoolean = cartService.selectGoodsAndUser("3", "5");
        System.out.println(aBoolean);
    }

    @Test
    public void test12(){
        CartServiceImpl cartService = new CartServiceImpl();
        BigDecimal price = new BigDecimal("262.5");
        BigDecimal nums = new BigDecimal("5");
        cartService.updateCart(price,nums,String.valueOf(5),String.valueOf(3));
    }

    @Test
    public void test13(){
        CartServiceImpl cartService = new CartServiceImpl();
        List<Cart> carts = cartService.selectGoodsByid(5);
        System.out.println(carts);
    }

    @Test
    public void test14(){
        AddressServiceImpl addressService = new AddressServiceImpl();
        Address address = new Address(2,5,"tom","四川","成都","武侯区","跳伞塔街道","13105776542","y",new User());
        addressService.addAddress(address);
    }

    @Test
    public void test15(){
        OrderServiceImpl orderService = new OrderServiceImpl();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        BigDecimal bigDecimal = new BigDecimal("99.8");
        Order order = new Order(1,"12345",3,format,"pig","131865","四川省成都市双流区xxx街道",bigDecimal,"支付宝","0");
        orderService.addOrder(order);
    }

    @Test
    public void test16(){
        AddressServiceImpl addressService = new AddressServiceImpl();
        Address typeAddress = addressService.findTypeAddress(5);
        System.out.println(typeAddress);
    }

    @Test
    public void test17(){
        PageHelperServiceImpl pageHelperService = new PageHelperServiceImpl();
        List<Goods> list = pageHelperService.PageHelperByGoods("中");
        System.out.println(list);
    }

    @Test
    public void test18(){
        PersonalServiceImpl personalService = new PersonalServiceImpl();
        List<Order> allOrder = personalService.findAllOrder("3");
        System.out.println(allOrder);
    }

    @Test
    public void test19(){
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        List<Goods> list = goodsService.FindAllHotGoodsLimit();
        System.out.println(list);
    }
}
