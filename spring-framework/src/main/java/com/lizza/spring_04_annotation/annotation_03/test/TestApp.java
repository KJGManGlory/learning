package com.lizza.spring_04_annotation.annotation_03.test;

import com.lizza.spring_04_annotation.annotation_03.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
public class TestApp {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void test1() {
       String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
