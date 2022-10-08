package com.service;

import com.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-29 16:51
 */
public interface PageHelperService {
    /**
     * 模糊查询，商品分页
     * @param name
     * @return
     */
    List<Goods> PageHelperByGoods(@Param("name") String name);
}
