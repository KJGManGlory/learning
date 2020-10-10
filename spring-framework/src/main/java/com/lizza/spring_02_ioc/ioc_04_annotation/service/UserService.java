package com.lizza.spring_02_ioc.ioc_04_annotation.service;

import com.lizza.spring_02_ioc.ioc_04_annotation.entity.User;

import java.util.List;

public interface UserService {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();
}
