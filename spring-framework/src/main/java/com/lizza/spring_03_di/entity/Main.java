package com.lizza.spring_03_di.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-09
 */
public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_03_beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
}
