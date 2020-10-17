package com.lizza.spring_04_annotation.annotation_06.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * 数据源配置类
 *
 * 读取配置文件中的数据
 * 1. @PropertySource 注解, 用来加载properties文件, value属性设置类路径; 使用时可以使用@Value注解
 *      或者在方法的参数中直接传入参数, 同样可以使用@Value来获取
 * 2. 继承EmbeddedValueResolverAware, 实现setEmbeddedValueResolver方法, 通过StringValueResolver
 *      来解析配置文件中的数据
 *
 * @Profile 根据环境条件加载Bean, 可以用于方法和类上
 * 使用方法: 使用@Profile("test")进行标记, 默认是default
 * 1. 命令启动方式设置: -Dspring.profiles.active=test
 * 2. 在创建容器的时候对环境变量进行设置
 *         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
 *         context.getEnvironment().setActiveProfiles("dev");
 *         context.register(SpringConfig.class);
 *         context.refresh();
 */
@PropertySource("classpath:/com/lizza/spring_04_annotation/annotation_06/config/db.properties")
@Configuration
public class DBConfig implements EmbeddedValueResolverAware {

    @Value("${db.username}")
    private String username;

    private String driverClass;

    @Profile("default")
    @Bean
    public DataSource DBTest(@Value("db.password") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource DBDev(@Value("db.password") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource DBProd(@Value("db.password") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
