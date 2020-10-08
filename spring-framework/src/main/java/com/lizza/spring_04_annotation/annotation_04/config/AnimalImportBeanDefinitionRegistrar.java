package com.lizza.spring_04_annotation.annotation_04.config;

import com.lizza.spring_04_annotation.annotation_04.entity.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
public class AnimalImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata: 注解元信息
     * BeanDefinitionRegistry: Bean定义的注册类
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition definition = new RootBeanDefinition(Cat.class);
        registry.registerBeanDefinition("cat", definition);
    }
}
