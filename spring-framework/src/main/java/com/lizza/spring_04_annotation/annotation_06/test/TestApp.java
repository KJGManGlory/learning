package com.lizza.spring_04_annotation.annotation_06.test;

import com.lizza.spring_04_annotation.annotation_06.config.SpringConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-17
 */
public class TestApp {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void test() {
        ComboPooledDataSource dataSource = context.getBean(ComboPooledDataSource.class);
        System.out.println("username: " + dataSource.getUser());
        System.out.println("password: " + dataSource.getPassword());
        System.out.println("url: " + dataSource.getJdbcUrl());
        System.out.println("driverClass: " + dataSource.getDriverClass());
    }
}
