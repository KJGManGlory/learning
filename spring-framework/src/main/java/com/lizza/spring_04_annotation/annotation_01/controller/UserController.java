package com.lizza.spring_04_annotation.annotation_01.controller;

import com.lizza.spring_04_annotation.annotation_01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-06
 */
public class UserController {

    public static void main(String[] args){
        // 1. 创建核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 2. 获取对象
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.saveUser();
    }
}
