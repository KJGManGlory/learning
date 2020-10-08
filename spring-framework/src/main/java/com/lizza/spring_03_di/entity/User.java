package com.lizza.spring_03_di.entity;

import lombok.Data;

import java.util.Date;

/**
 * spring 中的依赖注入 —— 构造器注入
 */
@Data
public class User {

    private String name;
    private Integer age;
    private Date birthday;

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
