package com.test;

import com.dao.cart.CartDao;
import com.dao.category.CategoryDao;
import com.dao.goods.GoodsDao;
import com.dao.user.UserDao;
import com.pojo.Cart;
import com.pojo.Category;
import com.pojo.Goods;
import com.pojo.User;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lifeng
 * @create 2022-09-22 15:52
 */
public class testDao {

    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        GoodsDao mapper = session.getMapper(GoodsDao.class);
        List<Goods> goods = mapper.FindAllNewGoodsLimit();
        for (Goods good : goods) {
            System.out.println(good);
        }
        session.close();
    }

    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        CategoryDao mapper = session.getMapper(CategoryDao.class);
        List<Category> allCateGory = mapper.findAllCateGory();
        for (Category category : allCateGory) {
            System.out.println(category);
        }
        session.close();
    }

    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.FindUserByUsername("admin");
        System.out.println(user);
        session.close();
    }

    @Test
    public void test4(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        GoodsDao mapper = session.getMapper(GoodsDao.class);
        List<Goods> goods = mapper.FindGoodListById(1, 0);
        for (Goods good : goods) {
            System.out.println(good);
        }
    }

    @Test
    public void test5(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        GoodsDao mapper = session.getMapper(GoodsDao.class);
        int i = mapper.selectCountGoods(1);
        System.out.println(i);
    }

    @Test
    public void test6(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = new User(3,"jerry","jerry","363500450@qq.com",null,"0","123456");
        mapper.addUser(user);
        //提交事务
        session.commit();
        session.close();
    }

    @Test
    public void test7(){
        SqlSession session = MybatisUtils.getMybatisSqlSession();
        UserDao mapper = session.getMapper(UserDao.class);
        mapper.updateByCode("51227761ad074e42aeb11aa7f418aa1a");
        session.commit();
        session.close();
    }

    @Test
    public void test8(){
        SqlSession mybatisSqlSession = MybatisUtils.getMybatisSqlSession();
        UserDao mapper = mybatisSqlSession.getMapper(UserDao.class);
        mapper.updateByCode("51227761ad074e42aeb11aa7f418aa1a");
        mybatisSqlSession.commit();
        mybatisSqlSession.close();
    }

    @Test
    public void test9(){
        SqlSession mybatisSqlSession = MybatisUtils.getMybatisSqlSession();
        CartDao mapper = mybatisSqlSession.getMapper(CartDao.class);
        Boolean aBoolean = mapper.selectGoodsAndUser("2", "5");
        System.out.println(aBoolean);
        mybatisSqlSession.close();
    }

    @Test
    public void test10(){
        SqlSession mybatisSqlSession = MybatisUtils.getMybatisSqlSession();
        CartDao mapper = mybatisSqlSession.getMapper(CartDao.class);
        List<Cart> carts = mapper.selectCartsByUserid(5);
        System.out.println(carts);
    }

}
