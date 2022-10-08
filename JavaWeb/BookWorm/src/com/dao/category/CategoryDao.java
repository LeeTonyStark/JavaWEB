package com.dao.category;

import com.pojo.Category;

import java.util.List;

/**
 * 首页种类列表
 * @author lifeng
 * @create 2022-09-22 21:52
 */
public interface CategoryDao {
    /**
     * 查询所有的种类
     * @return
     */
    List<Category> findAllCateGory();
}
