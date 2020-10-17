package com.lizza.spring_02_ioc.ioc_01_base.service.impl;

import com.lizza.spring_02_ioc.ioc_01_base.service.UserService;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-06
 */
public class UserServiceImpl implements UserService {

    // new的方式创建对象，增加了耦合度
    // private UserDao userDao = new UserDao();

    @Override
    public void saveUser(){
        System.out.println("Calculator: user saved!");
    }
}
