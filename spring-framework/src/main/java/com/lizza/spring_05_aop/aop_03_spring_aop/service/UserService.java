package com.lizza.spring_05_aop.aop_03_spring_aop.service;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class UserService {

    public void add() {
        System.out.println("新增用户...");
    }

    public int delete() {
        System.out.println("删除用户...");
        return 1;
    }

    public void update(int i) {
        System.out.println("更新用户...");
    }
}
