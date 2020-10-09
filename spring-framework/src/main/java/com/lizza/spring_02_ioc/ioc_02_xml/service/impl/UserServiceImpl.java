package com.lizza.spring_02_ioc.ioc_02_xml.service.impl;

import com.lizza.spring_02_ioc.ioc_02_xml.dao.UserDao;
import com.lizza.spring_02_ioc.ioc_02_xml.entity.User;
import com.lizza.spring_02_ioc.ioc_02_xml.service.UserService;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-11
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 使用set注入dao
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int addOne(User user) {
        return userDao.addOne(user);
    }

    @Override
    public int deleteOne(int id) {
        return userDao.deleteOne(id);
    }

    @Override
    public int updateOne(User user) {
        return userDao.updateOne(user);
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
