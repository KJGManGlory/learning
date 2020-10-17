package com.lizza.spring_04_annotation.annotation_06.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 数据源配置类
 *
 * 读取配置文件中的数据
 * 1. @
 */
@PropertySource("classpath:/com/lizza/spring_04_annotation/annotation_06/config/db.properties")
@Configuration
public class DBConfig {

    @Value("${db.username}")
    private String username;

    @Bean
    public DataSource DBTest() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
