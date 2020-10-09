package com.lizza.spring_05_aop.aop_03_spring_aop.test;

import com.lizza.spring_05_aop.aop_03_spring_aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class Client {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_06_beans.xml")	;
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        userService.delete();
        userService.update(1);
    }
}
