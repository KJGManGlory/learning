package com.lizza.spring_04_annotation.annotation_04.test;

import com.lizza.spring_04_annotation.annotation_04.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 向容器中注册Bean
 * 1. 常用注解: @Controller, @Service, @Repository, @Component; 用于自己定义的类
 * 2. @Bean: 用于第三方jar
 * 3. @Import: 快速注册组件
 *      1) Class对象数组
 *      2) ImportSelector Class对象: 可以自定义注册规则
 *      3) ImportBeanDefinitionRegistrar Class对象: 同样可以自定义Bean的注册规则
 * 4. 通过实现FactoryBean接口来注册Bean
 *      1) 默认获取的是getObject方法返回的对象
 *      2) 若需要获取FactoryBean本身, 则需要在bean的name前加&符号: &animalFactoryBean
 */




public class TestApp {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void test1() {
        printBeans();
    }

    @Test
    public void test2() {
        Object object = context.getBean("animalFactoryBean");
        System.out.println(object);
        Object factory = context.getBean("&animalFactoryBean");
        System.out.println(factory);
    }

    /**
     * 打印系统环境变量
     * @author: lizza1643@gmail.com
     * @date: 2020/10/8 12:53 下午
     * @param
     * @return void
     */
    private void printEnvs() {
        ConfigurableEnvironment environment = context.getEnvironment();
        Map<String, Object> properties = environment.getSystemProperties();
        properties.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    /**
     * 打印容器中注册的Bean
     * @author: lizza1643@gmail.com
     * @date: 2020/10/8 12:53 下午
     * @param
     * @return void
     */
    private void printBeans() {
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Registered Bean: " + name);
        }
    }
}
