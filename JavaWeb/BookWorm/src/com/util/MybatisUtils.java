package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lifeng
 * @create 2022-09-10 14:52
 */
public class MybatisUtils {

    static SqlSessionFactory factory = null;

    static {
        //1.获取流对象，读取核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.创建sqlSession工厂的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //3.获取sqlSession工厂对象
        factory = builder.build(is);
    }

    public static SqlSession getMybatisSqlSession() {

        //4.获取sqlSession对象
        SqlSession session = factory.openSession();

        //5.获取UserDao的代理对象
//        Object mapper = session.getMapper(Object.class);

        return session;

    }

}
