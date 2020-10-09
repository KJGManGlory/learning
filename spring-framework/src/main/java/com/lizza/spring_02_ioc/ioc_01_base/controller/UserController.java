package com.lizza.spring_02_ioc.ioc_01_base.controller;

import com.lizza.spring_02_ioc.ioc_01_base.dao.UserDao;
import com.lizza.spring_02_ioc.ioc_01_base.service.UserService;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_02_beans.xml");
        // 2. 获取对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.saveUser();
        UserDao userDao = context.getBean("userDao5", UserDao.class);
        userDao.saveUser();
    }
}
