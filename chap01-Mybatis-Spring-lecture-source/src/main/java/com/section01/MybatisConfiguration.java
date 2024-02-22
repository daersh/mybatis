package com.section01;
import org.apache.ibatis.session.*;

import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        org.apache.ibatis.session.Configuration configuration
                = new org.apache.ibatis.session.Configuration();
        configuration.addMapper(MenuMapper.class);

        factoryBean.setDate
    }
}
