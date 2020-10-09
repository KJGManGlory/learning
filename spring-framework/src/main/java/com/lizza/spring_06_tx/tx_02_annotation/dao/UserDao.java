package com.lizza.spring_06_tx.tx_02_annotation.dao;

import com.lizza.spring_06_tx.tx_02_annotation.entity.User;
import java.util.List;

public interface UserDao {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();
}
