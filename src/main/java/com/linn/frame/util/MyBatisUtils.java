package com.linn.frame.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static Logger logger = LoggerFactory.getLogger(MyBatisUtils.class);

    private volatile static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory==null) {
            SqlSessionFactory ssf;
            synchronized(MyBatisUtils.class) {
                ssf = sqlSessionFactory;
                if (ssf == null) {
                    synchronized(MyBatisUtils.class) {
                        if(ssf == null) {
                            String resource = "mybatis-config.xml";
                            InputStream inputStream = Resources.getResourceAsStream(resource);
                            ssf = new SqlSessionFactoryBuilder().build(inputStream);
                        }
                    }
                    sqlSessionFactory=ssf;
                }
            }
        }
        System.out.println(sqlSessionFactory);
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() throws IOException {
        return getSqlSessionFactory().openSession();
    }
}
