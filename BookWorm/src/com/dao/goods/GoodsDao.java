package com.dao.goods;

import com.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 14:00
 */
public interface GoodsDao {

    /**
     * 分页查询所有最新商品
     * @return
     */
    List<Goods> FindAllNewGoodsLimit();

    /**
     * 分页查询所有最新商品
     * @return
     */
    List<Goods> FindAllHotGoodsLimit();

    /**
     * 根据分类id获取图书
     * @param cid 分类id
     * @param page 页码
     * @return
     */
    List<Goods> FindGoodListById(@Param("cid") int cid,@Param("page") int page);

    /**
     * 根据类别id获取总商品数
     * @param cid
     * @return
     */
    int selectCountGoods(int cid);

    /**
     * 根据商品id查询数据库
     * @param id 商品id
     * @return 商品集合
     */
    Goods findAllGoodsById(String id);
}
