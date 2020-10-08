package com.lizza.spring_04_annotation.annotation_04.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否为MacOS系统
 */
public class MacOSCondition implements Condition {

    /**
     * ConditionContext: 判断条件, 上下文环境
     * AnnotatedTypeMetadata: 注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取对象工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取系统环境信息
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if (osName.equals("Mac OS X")) {
            return true;
        }
        return false;
    }
}
