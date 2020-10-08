package com.lizza.spring_04_annotation.annotation_04.test;

import com.lizza.spring_04_annotation.annotation_04.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 向容器中
 */
public class TestApp {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void test1() {
        printBeans();
        printEnvs();
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
