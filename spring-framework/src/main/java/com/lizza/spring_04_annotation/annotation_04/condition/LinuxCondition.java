package com.lizza.spring_04_annotation.annotation_04.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否为Linux系统
 */
public class LinuxCondition implements Condition {

    /**
     * ConditionContext: 判断条件, 上下文环境
     * AnnotatedTypeMetadata: 注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if (osName.equals("Linux")) {
            return true;
        }
        return false;
    }
}
