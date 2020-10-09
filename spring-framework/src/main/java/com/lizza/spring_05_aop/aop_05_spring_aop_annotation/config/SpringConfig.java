package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-28
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lizza.spring_05_aop.aop_05_spring_aop_annotation")
public class SpringConfig {

}
