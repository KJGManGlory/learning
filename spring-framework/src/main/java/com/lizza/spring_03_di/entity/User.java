package com.lizza.spring_03_di.entity;

import java.util.Date;

/**
 * spring 中的依赖注入 —— 构造器注入
 */
public class User {

    private String name;
    private Integer age;
    private Date birthday;

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
