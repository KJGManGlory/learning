package com.lizza.spring_04_annotation.annotation_05.config;

import com.lizza.spring_04_annotation.annotation_05.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Configuration
public class BeanConfig {

    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Student student() {
        return new Student();
    }
}
