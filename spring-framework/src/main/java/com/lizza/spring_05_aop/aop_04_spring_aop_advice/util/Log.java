package com.lizza.spring_05_aop.aop_04_spring_aop_advice.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Desc: 通知的类型
 * @author: lizza1643@gmail.com
 * @date: 2020-03-26
 */
public class Log {

    /**
     * 前置通知：切入点执行之前执行
     */
    public void beforeLog() {
        System.out.println("前置通知：记录日志...");
    }

    /**
     * 后置通知：切入点执行之后执行
     */
    public void afterLog() {
        System.out.println("后置通知：记录日志...");
    }

    /**
     * 异常通知：切入点执行发生异常时执行
     */
    public void exceptionLog() {
        System.out.println("异常通知：记录日志...");
    }

    /**
     * 最终通知：无论切入点执行发生异常与否，都会执行
     */
    public void finalLog() {
        System.out.println("最终通知：记录日志...");
    }

    /**
     * 环绕通知
     * 使用方式：
     *      使用spring提供的ProceedingJoinPoint接口，调用proceed()方法来执行切入点
     *      方法，在proceed()前后以编码的方式实现前置，后置，异常，最终通知
     * 意义：
     *      spring环绕通知提供了一种可以通过编码方式指定增强方式何时执行的方式
     */
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
