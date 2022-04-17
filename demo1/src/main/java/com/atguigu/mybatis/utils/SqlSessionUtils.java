package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-13-22:08
 */

//获取sqlSession的工具类
public class SqlSessionUtils {

    public static SqlSession getSession() throws IOException {

        //加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //获得SqlSessionFactory
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交

        return sqlSession;
    }

}
