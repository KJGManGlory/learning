package com.lizza.spring_04_annotation.annotation_04.config;

import com.lizza.spring_04_annotation.annotation_04.entity.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Component
public class AnimalFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
