package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.service;

import org.springframework.stereotype.Service;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
@Service
public class UserService {

    public void add() {
        System.out.println("新增用户...");
//        int i = 1/0;
    }

    public int delete() {
        System.out.println("删除用户...");
        return 1;
    }

    public void update(int i) {
        System.out.println("更新用户...");
    }
}
