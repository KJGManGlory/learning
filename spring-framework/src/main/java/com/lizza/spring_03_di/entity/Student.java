package com.lizza.spring_03_di.entity;

import java.util.Date;

/**
 * spring 中的依赖注入 —— set方法注入
 */
public class Student {

    private String name;
    private Integer age;
    private Date birthday;

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
