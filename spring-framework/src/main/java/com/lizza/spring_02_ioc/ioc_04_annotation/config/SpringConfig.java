package com.lizza.spring_02_ioc.ioc_04_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration
 *   作用：指定当前的类是一个配置类
 *   细节：当使用AnnotationConfigApplicationContext创建容器时，参数所对应的类无需@Configuration注解修饰
 * @ComponentScan
 *   作用：指定spring在创建容器时要扫描的包
 *   属性：value，basePackages，用于指定创建容器时要扫描的包路径
 *   xml标签：<context:component-scan base-package="com.lizza"/>
 * @Bean
 *   作用：把当前方法的返回值作为bean对象存入spring容器中
 *   属性：name，用于指定bean的id；默认值为方法名称
 *   细节：当我们用@Bean去注解方法时，如果方法有参数，spring会按照@Autowired方式来注入参数
 * @Import
 *   作用：导入其他配置类
 *   属性：value，用于指定其他配置类的字节码；使用@Import注解的配置类为主配置类，导入的为子配置类
 * @PropertySource
 *   作用：用于指定properties文件的位置
 *   属性：value，配置文件的路径和名称；关键字：classpath表示根路径
 */
@ComponentScan("com.lizza")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

}
