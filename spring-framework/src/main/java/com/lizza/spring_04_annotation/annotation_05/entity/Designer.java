package com.lizza.spring_04_annotation.annotation_05.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Component
public class Designer {

    public Designer() {
        System.out.println("Designer Constructor Invoked ... ");
    }

    @PostConstruct
    public void init() {
        System.out.println("Designer Init ... ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Designer Destroy ... ");
    }
}
