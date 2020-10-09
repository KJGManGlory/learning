package com.lizza.spring_02_ioc.ioc_02_xml.test;

import com.lizza.spring_02_ioc.ioc_02_xml.entity.User;
import com.lizza.spring_02_ioc.ioc_02_xml.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestApp {

    @Test
    public void addOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_09_beans.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setId(4);
        user.setName("test");
        user.setAge(19);

        Assert.assertEquals(1, userService.addOne(user));
    }

    @Test
    public void deleteOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);

        Assert.assertEquals(1, userService.deleteOne(4));

    }

    @Test
    public void updateOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setId(4);
        user.setName("test");
        user.setAge(0);
        Assert.assertEquals(0, userService.updateOne(user));
    }

    @Test
    public void findOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.findOne(1);
        Assert.assertEquals(1, user.getId());
    }

    @Test
    public void findAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> list = userService.findAll();
        Assert.assertNotNull(list);
    }
}