package com.lizza.spring_01_beanfactory.service.impl;

import com.lizza.spring_01_beanfactory.dao.UserDao;
import com.lizza.spring_01_beanfactory.service.UserService;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-06
 */
public class UserServiceImpl implements UserService {

    // new的方式创建对象，增加了耦合度
    private UserDao userDao = new UserDao();

    private int i;

    @Override
    public void saveUser(){
        userDao.saveUser();
        System.out.println(i);
        i++;
    }
}
