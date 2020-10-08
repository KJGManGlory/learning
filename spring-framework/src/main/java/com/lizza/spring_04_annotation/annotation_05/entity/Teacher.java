package com.lizza.spring_04_annotation.annotation_05.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Component
public class Teacher implements InitializingBean, DisposableBean {

    public Teacher() {
        System.out.println("Teacher Constructor Invoked ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Teacher Init ... ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Teacher Destroy ... ");
    }
}
