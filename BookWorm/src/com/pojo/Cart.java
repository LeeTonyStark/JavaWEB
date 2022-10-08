package com.pojo;

import java.math.BigDecimal;

/**
 * 购物车实体类
 * @author lifeng
 * @create 2022-09-27 11:52
 */
public class Cart {
    private int id;//购物车id
    private int userid;//用户id
    private int goodsid;//商品id
    private BigDecimal price;//商品价格
    private BigDecimal nums;//商品数量
    private Goods goods;//商品

    public Cart() {
    }

    public Cart(int id, int userid, int goodsid, BigDecimal price, BigDecimal nums, Goods goods) {
        this.id = id;
        this.userid = userid;
        this.goodsid = goodsid;
        this.price = price;
        this.nums = nums;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNums() {
        return nums;
    }

    public void setNums(BigDecimal nums) {
        this.nums = nums;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodsid=" + goodsid +
                ", price=" + price +
                ", nums=" + nums +
                ", goods=" + goods +
                '}';
    }
}
