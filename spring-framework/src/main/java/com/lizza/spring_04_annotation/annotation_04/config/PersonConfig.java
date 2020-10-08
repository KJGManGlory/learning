package com.lizza.spring_04_annotation.annotation_04.config;

import com.lizza.spring_04_annotation.annotation_04.condition.LinuxCondition;
import com.lizza.spring_04_annotation.annotation_04.condition.MacOSCondition;
import com.lizza.spring_04_annotation.annotation_04.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
@Configuration
public class PersonConfig {

    @Bean
    @Conditional(MacOSCondition.class)
    public com.lizza.spring_04_annotation.annotation_04.entity.Person jobs() {
        return new com.lizza.spring_04_annotation.annotation_04.entity.Person("Steve jobs", 63);
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public com.lizza.spring_04_annotation.annotation_04.entity.Person linus() {
        return new Person("Linus", 43);
    }
}
