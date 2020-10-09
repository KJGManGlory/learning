package com.lizza.spring_04_annotation.annotation_05.test;

import com.lizza.spring_04_annotation.annotation_05.config.SpringConfig;
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
 * 3. 使用JSR250定义的两个注解
 *      @PostConstruct: 在bean创建完成并且完成属性赋值工作后, 进行调用执行初始化方法
 *      @PreDestroy: 在容器销毁之前通知我们进行清理工作
 * 4. BeanPostProcessor接口
 *      postProcessBeforeInitialization() 方法: 在构造方法之后, 初始化方法之前执行
 *      postProcessAfterInitialization() 方法: 初始化方法之后执行
 *
 * BeanPostProcessor原理
 *
 * Spring底层对 BeanPostProcessor 的使用
 * 1. 获取IoC容器
 *      1) Bean实现ApplicationContextAware接口
 *      2) ApplicationContextAwareProcessor类实现了BeanPostProcessor接口,
 *          invokeAwareInterfaces()方法中对ApplicationContext进行了赋值操作
 *
 */
public class TestApp {



    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Registered Bean: " + name);
        }
    }
}
