package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Desc: 通知的类型
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
@Aspect
@Component
public class Log {

    @Pointcut("execution(* com.lizza.spring_05_aop.aop_05_spring_aop_annotation..*())")
    public void pointCut() {}

    /**
     * 前置通知：切入点执行之前执行
     */
    @Before("pointCut()")
    public void beforeLog() {
        System.out.println("前置通知：记录日志...");
    }

    /**
     * 后置通知：切入点执行之后执行
     */
    @AfterReturning("pointCut()")
    public void afterLog() {
        System.out.println("后置通知：记录日志...");
    }

    /**
     * 异常通知：切入点执行发生异常时执行
     */
    @AfterThrowing("pointCut()")
    public void exceptionLog() {
        System.out.println("异常通知：记录日志...");
    }

    /**
     * 最终通知：无论切入点执行发生异常与否，都会执行
     * 注意：基于注解的最终通知总会在后置通知或者异常通知之前执行
     */
    @After("pointCut()")
    public void finalLog() {
        System.out.println("最终通知：记录日志...");
    }

    /**
     * 环绕通知
     */
//    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint point) {
        Object result;
        try {
            System.out.println("环绕通知-前置：记录日志...");
            Object[] args = point.getArgs();            // 获取方法执行的参数
            result = point.proceed(args);               // 执行切入点方法
            System.out.println("环绕通知-后置：记录日志...");
            return result;
        } catch (Throwable t) {
            System.out.println("环绕通知-异常：记录日志...");
            throw new RuntimeException(t);
        } finally {
            System.out.println("环绕通知-最终：记录日志...");
        }
    }
}
