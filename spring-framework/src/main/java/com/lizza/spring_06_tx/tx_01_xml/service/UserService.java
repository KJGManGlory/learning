package com.lizza.spring_06_tx.tx_01_xml.service;

import com.lizza.spring_06_tx.tx_01_xml.entity.User;

import java.util.List;

public interface UserService {

    int addOne(User user);

    int deleteOne(int id);

    int updateOne(User user);

    User findOne(int id);

    List<User> findAll();

    int transferMoney(int from_id, int to_id, double money);
}
