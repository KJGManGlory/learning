package com.lizza.spring_04_annotation.annotation_05.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
     * 执行时机: 在构造方法之后, 初始化方法之前执行
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " Before Initialization ... ");
        return bean;
    }

    /**
     * 执行时机: 初始化方法之后执行
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " After Initialization ... ");
        return bean;
    }
}
