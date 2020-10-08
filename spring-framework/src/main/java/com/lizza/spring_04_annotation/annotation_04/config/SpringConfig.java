package com.lizza.spring_04_annotation.annotation_04.config;

import com.lizza.spring_04_annotation.annotation_04.condition.LinuxCondition;
import com.lizza.spring_04_annotation.annotation_04.condition.MacOSCondition;
import com.lizza.spring_04_annotation.annotation_04.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Conditional注解
 * 1.
 */
@Configuration
@ComponentScan(value = "com.lizza.spring_04_annotation.annotation_04")
public class SpringConfig {

}
