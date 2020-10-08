package com.lizza.spring_04_annotation.annotation_03.config;

import com.lizza.spring_04_annotation.annotation_03.entity.Book;
import org.springframework.context.annotation.*;

/**
 * 1. excludeFilters: 指定扫描时需要排除哪些组件
 * 2. includeFilters: 指定扫描时只需要包含哪些组件; 使用此属性时, 需要将useDefaultFilters设置为false
 * 3. FilterType: 指定过滤的类型
 */

/**
 * 自定义过滤器:
 * 1. 实现TypeFilter接口, 重写match方法
 */
@Configuration
@ComponentScan(value = "com.lizza.spring_04_annotation.annotation_03", includeFilters = {
        @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {CustomFilter.class}),
}, useDefaultFilters = false)
public class SpringConfig {

    @Lazy
    @Bean
    public Book book() {
        Book book = new Book();
        return book;
    }
}
