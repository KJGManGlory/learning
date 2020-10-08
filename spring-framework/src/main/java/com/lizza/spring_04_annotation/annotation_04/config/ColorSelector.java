package com.lizza.spring_04_annotation.annotation_04.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
public class ColorSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{
                "com.lizza.spring_04_annotation.annotation_04.entity.Black",
                "com.lizza.spring_04_annotation.annotation_04.entity.White"
        };
    }
}
