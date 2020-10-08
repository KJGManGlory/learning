package com.lizza.spring_04_annotation.annotation_04.config;

import com.lizza.spring_04_annotation.annotation_04.entity.Blue;
import com.lizza.spring_04_annotation.annotation_04.entity.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import
 * 该注解用于快速向容器中注册Bean
 */
@Configuration
@Import({Red.class, Blue.class, ColorSelector.class})
public class ColorConfig {

}
