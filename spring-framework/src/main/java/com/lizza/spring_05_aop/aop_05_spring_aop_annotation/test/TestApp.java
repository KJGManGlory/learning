package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.test;

import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.config.SpringConfig;
import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.service.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class TestApp {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Calculator calculator = context.getBean(Calculator.class);
        calculator.division(1, 1);
    }
}
