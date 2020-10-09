package com.lizza.spring_05_aop.service;

import com.lizza.spring_05_aop.entity.User;

import java.util.List;

public interface UserService {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();

    int transferMoney(Integer originAccount, Integer targetAccount, Double money);
}
