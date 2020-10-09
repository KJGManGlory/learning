package com.lizza.spring_06_tx.tx_01_xml.dao;

import com.lizza.spring_06_tx.tx_01_xml.entity.User;

import java.util.List;

public interface UserDao {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();
}
