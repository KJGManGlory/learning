package com.lizza.spring_02_ioc.ioc_04_annotation.service.impl;

import com.lizza.spring_02_ioc.ioc_04_annotation.dao.UserDao;
import com.lizza.spring_02_ioc.ioc_04_annotation.entity.User;
import com.lizza.spring_02_ioc.ioc_04_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-11
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

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
