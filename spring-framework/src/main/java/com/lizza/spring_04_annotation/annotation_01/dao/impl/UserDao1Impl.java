package com.lizza.spring_04_annotation.annotation_01.dao.impl;

import com.lizza.spring_04_annotation.annotation_01.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-11
 */
@Repository("userDao1")
public class UserDao1Impl implements UserDao {

    @Value("1")
    int index;

    @Override
    public void saveUser() {
        System.out.println("UserDao" + index + ": user saved!");
    }
}
