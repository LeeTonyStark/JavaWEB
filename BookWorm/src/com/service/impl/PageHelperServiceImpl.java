package com.service.impl;

import com.dao.pageHelper.PageHelperDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.pojo.Goods;
import com.service.PageHelperService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-29 16:52
 */
public class PageHelperServiceImpl implements PageHelperService {

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    PageHelperDao mapper = session.getMapper(PageHelperDao.class);

    @Override
    public List<Goods> PageHelperByGoods(String name) {
        PageHelper.startPage(1,12);//从第一页开始，每页显示12条记录
        List<Goods> list = mapper.PageHelperByGoods(name);
        return list;
    }
}
