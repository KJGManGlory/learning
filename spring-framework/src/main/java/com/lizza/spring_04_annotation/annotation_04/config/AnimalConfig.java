package com.lizza.spring_04_annotation.annotation_04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Configuration
@Import({AnimalImportBeanDefinitionRegistrar.class})
public class AnimalConfig {

}
