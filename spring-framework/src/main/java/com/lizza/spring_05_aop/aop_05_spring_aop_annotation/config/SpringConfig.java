package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * spring AOP
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lizza.spring_05_aop.aop_05_spring_aop_annotation")
public class SpringConfig {

}
