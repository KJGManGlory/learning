package com.lizza.spring_04_annotation.annotation_02.config;

import com.lizza.spring_04_annotation.annotation_02.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * 1. excludeFilters: 指定扫描时需要排除哪些组件
 * 2. includeFilters: 指定扫描时只需要包含哪些组件; 使用此属性时, 需要将useDefaultFilters设置为false
 * 3. FilterType: 指定过滤的类型
 */
@Configuration
@ComponentScan(value = "com.lizza.spring_04_annotation.annotation_02", excludeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Service.class})
})
public class SpringConfig {

    @Bean
    public Book book() {
        Book book = new Book();
        return book;
    }
}
