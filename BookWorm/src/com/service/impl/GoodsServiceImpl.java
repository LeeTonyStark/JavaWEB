package com.service.impl;

import com.dao.goods.GoodsDao;
import com.pojo.Goods;
import com.pojo.PageBean;
import com.service.GoodsService;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 16:37
 */
public class GoodsServiceImpl implements GoodsService{

    SqlSession session = MybatisUtils.getMybatisSqlSession();
    GoodsDao goodsDao = session.getMapper(GoodsDao.class);

    @Override
    public List<Goods> FindAllNewGoodsLimit() {

        List<Goods> goods = goodsDao.FindAllNewGoodsLimit();
        session.close();
        return goods;
    }

    @Override
    public List<Goods> FindAllHotGoodsLimit() {
        List<Goods> list = goodsDao.FindAllHotGoodsLimit();
        session.close();
        return list;
    }

    @Override
    public PageBean FindPageById(int cid, int pageNo) {

        PageBean<Goods> pageBean = new PageBean<>();
        //设置当前页码
        pageBean.setPageNo(pageNo);
        //设置商品总条数（从数据库查）
        int i = goodsDao.selectCountGoods(cid);
        pageBean.setCount(i);
        //设置每页显示条数,每页显示12条
        pageBean.setPageSize(12);
        //设置总页数
        int pages = i % 12 == 0 ? i / 12 : (i / 12) + 1;
        pageBean.setPages(pages);
        //设置每页显示的数据
        List<Goods> goods = goodsDao.FindGoodListById(cid, (pageNo - 1)*12);
        pageBean.setList(goods);

        return pageBean;
    }

    @Override
    public Goods findAllGoodsById(String id) {
        Goods goods = goodsDao.findAllGoodsById(id);
        return goods;
    }

}
