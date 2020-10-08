package com.lizza.spring_04_annotation.annotation_05.test;

import com.lizza.spring_04_annotation.annotation_05.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean的生命周期
 * 1. Bean的生命周期指的是一个Bean从创建 -> 初始化 -> 销毁的过程
 * 2. Bean的生命周期由IoC容器来管理
 * 3. 我们可以自定义Bean的创建和销毁方法
 *
 * Bean的创建
 *      1) 单例: 容器启动时创建对象
 *      2) 多例: 每次使用时创建对象
 *
 * Bean的初始化
 *      1) 单例: 容器启动时创建对象, 对象创建完成后进行初始化
 *      2) 多例: 每次使用时创建对象, 对象创建完成后进行初始化
 *
 * Bean的销毁
 *      1) 单例: 容器销毁时销毁对象
 *      2) 多例: 需要主动调用对象的销毁方法销毁
 *
 * 使用方法:
 * 1. @Bean注解中指定初始化和销毁的方法: initMethod(), destroyMethod()
 * 2. Bean实现InitializingBean, DisposableBean接口
 *      在afterPropertiesSet()方法中实现初始化逻辑
 *      在destroy()方法中实现销毁逻辑
 *
 *
 */
public class TestApp {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void test1() {
        System.out.println("Context Created ...");
        context.getBean("student");
        context.close();
        System.out.println("Context Closed ...");
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
