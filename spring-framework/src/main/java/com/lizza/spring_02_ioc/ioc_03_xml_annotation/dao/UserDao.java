package com.lizza.spring_02_ioc.ioc_03_xml_annotation.dao;

import com.lizza.spring_02_ioc.ioc_03_xml_annotation.entity.User;

import java.util.List;

public interface UserDao {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();
}
