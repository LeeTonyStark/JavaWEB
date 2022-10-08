package com.service;

import com.pojo.Goods;
import com.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 16:37
 */
public interface GoodsService {
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
     * @param pageNo 页码
     * @return
     */
    PageBean FindPageById(int cid,int pageNo);

    /**
     * 根据商品id查询数据库
     * @param id 商品id
     * @return 商品集合
     */
    Goods findAllGoodsById(String id);

}
