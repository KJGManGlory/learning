package com.lizza.spring_02_ioc.ioc_04_annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-20
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public QueryRunner getQueryRunner(ComboPooledDataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean
    public ComboPooledDataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
