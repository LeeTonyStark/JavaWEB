package com.service;

import com.pojo.Category;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 22:02
 */
public interface CategoryService {
    /**
     * 查询所有的种类
     * @return
     */
    List<Category> findAllCateGory();
}
