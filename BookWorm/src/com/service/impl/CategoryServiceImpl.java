package com.service.impl;

import com.dao.category.CategoryDao;
import com.pojo.Category;
import com.service.CategoryService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 22:03
 */
public class CategoryServiceImpl implements CategoryService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    CategoryDao mapper = session.getMapper(CategoryDao.class);

    @Override
    public List<Category> findAllCateGory() {

        List<Category> allCateGory = mapper.findAllCateGory();
        return allCateGory;
    }
}
