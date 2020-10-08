package com.lizza.spring_01_beanfactory.controller;

import com.lizza.spring_01_beanfactory.factory.BeanFactory;
import com.lizza.spring_01_beanfactory.service.UserService;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-06
 */
public class UserController {

    public static void main(String[] args){
        // new创建的对象增加了代码的耦合度，使用工厂来解耦
        // UserService userService = new UserServiceImpl();
        UserService userService = BeanFactory.getBean("userService");
        userService.saveUser();
    }
}
