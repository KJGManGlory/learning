package com.lizza.spring_05_aop.aop_01_aop.dao;

import com.lizza.spring_05_aop.aop_01_aop.entity.User;

import java.util.List;

public interface UserDao {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();
}
