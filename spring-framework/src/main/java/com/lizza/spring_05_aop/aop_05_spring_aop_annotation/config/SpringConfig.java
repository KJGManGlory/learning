package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.config;

import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.service.Calculator;
import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.util.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * spring AOP使用
 * 1. 导入aop模块: spring-aspects
 * 2. 定义业务逻辑类: Calculator
 * 3. 定义切面类: Log
 * 4. 标注切面类的目标方法何时何地执行
 *      前置通知(@Before): 方法执行之前运行
 *      后置通知(@After): 方法执行完成后运行
 *      返回通知(@AfterReturning): 方法正常执行返回结果后运行
 *      异常通知(@AfterThrowing): 方法执行发生异常后运行
 *      环绕通知(@Around): 动态代理, 手动推进程序的执行
 * 5. 将业务逻辑类和切面类注册到容器中
 * 6. 标注哪个类是切面类: @Aspect
 * 7. 开启基于注解的AOP模式: @EnableAspectJAutoProxy
 *
 * spring AOP原理
 * 1. 研究@EnableAspectJAutoProxy
 *      @Import(AspectJAutoProxyRegistrar.class) 利用AspectJAutoProxyRegistrar
 *      自定义注册bean: AnnotationAwareAspectJAutoProxyCreator(自动代理创建器)
 * 2. AnnotationAwareAspectJAutoProxyCreator
 *      AnnotationAwareAspectJAutoProxyCreator的继承关系:
 *      AnnotationAwareAspectJAutoProxyCreator
 *          > AspectJAwareAdvisorAutoProxyCreator
 *              > AbstractAdvisorAutoProxyCreator
 *                  > AbstractAutoProxyCreator(实现了SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware)
 *      * SmartInstantiationAwareBeanPostProcessor: 后置处理器
 *      * BeanFactoryAware:
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lizza.spring_05_aop.aop_05_spring_aop_annotation")
public class SpringConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public Log log() {
        return new Log();
    }
}
