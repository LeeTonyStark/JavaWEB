package com.service.impl;


import com.dao.cart.CartDao;
import com.pojo.Cart;
import com.service.CartService;
import com.util.MailUtils;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author lifeng
 * @create 2022-09-27 14:47
 */
public class CartServiceImpl implements CartService {

        SqlSession session = MybatisUtils.getMybatisSqlSession();
        CartDao mapper = session.getMapper(CartDao.class);
    @Override
    public Boolean selectGoodsAndUser(String goodsid, String userid) {
        Boolean aBoolean = mapper.selectGoodsAndUser(goodsid, userid);
        return aBoolean;
    }

    @Override
    public void addCart(Cart cart) {
        mapper.addCart(cart);
        //提交事务
        session.commit();
    }

    @Override
    public Cart selectCartByUserid(String userid, String goodsid) {
        Cart carts = mapper.selectCartByUserid(userid, goodsid);
        return carts;
    }

    @Override
    public void updateCart(BigDecimal newPrice, BigDecimal newNums, String userid, String goodsid) {
        mapper.updateCart(newPrice,newNums,userid,goodsid);
        //提交事务
        session.commit();
    }

    @Override
    public List<Cart> selectGoodsByid(int userid) {
        List<Cart> carts = mapper.selectGoodsByid(userid);
        return carts;
    }


}
