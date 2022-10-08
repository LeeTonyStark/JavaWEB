package com.dao.cart;

import com.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-27 14:33
 */
public interface CartDao {
    /**
     * 根据商品id和用户id查询购物车
     * @param goodsid
     * @param userid
     * @return
     */
    Boolean selectGoodsAndUser(@Param("goodsid") String goodsid,@Param("userid") String userid);

    /**
     * 插入购物车数据
     * @param cart
     */
    void addCart(Cart cart);

    /**
     * 根据用户名和商品id查询购物车
     * @param userid
     * @return
     */
    Cart selectCartByUserid(@Param("userid") String userid,@Param("goodsid") String goodsid);

    /**
     * 修改商品库存以及小计
     * @param
     */
    void updateCart(@Param("newPrice") BigDecimal newPrice,@Param("newNums") BigDecimal newNums,@Param("userid") String userid,@Param("goodsid") String goodsid);

    /**
     * 根据用户名查询出所有的商品id
     * @param userid
     * @return
     */
    List<Cart> selectCartsByUserid(int userid);

    /**
     * 多对一查询
     * 查询商品表，顺带查询对应的商品id
     * @return
     */
    List<Cart> selectGoodsByid(@Param("userid") int userid);
}
