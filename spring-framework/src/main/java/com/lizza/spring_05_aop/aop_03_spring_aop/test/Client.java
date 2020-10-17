package com.lizza.spring_05_aop.aop_03_spring_aop.test;

import com.lizza.spring_05_aop.aop_03_spring_aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP: 实现原理为动态代理; AOP是指在程序运行期间动态的将某段代码切入
 * 指定位置进行运行的编程方式
 *
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
