package com.section01.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession GetSqlSession(){
        if(sqlSessionFactory==null){
            String resource = "config/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }

}
