package com.lizza.spring_03_di.entity;

import lombok.Data;

import java.util.Date;

/**
 * spring 中的依赖注入 —— set方法注入
 */
@Data
public class Student {

    private String name;
    private Integer age;
    private Date birthday;
}
