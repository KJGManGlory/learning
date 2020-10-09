package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.test;

import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.config.SpringConfig;
import com.lizza.spring_05_aop.aop_05_spring_aop_annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class Client {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
