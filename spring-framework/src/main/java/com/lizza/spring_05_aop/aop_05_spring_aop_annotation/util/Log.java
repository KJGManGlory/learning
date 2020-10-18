package com.lizza.spring_05_aop.aop_05_spring_aop_annotation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 1. @Pointcut抽取切入点表达式; 本类引用: pointCut()
 * 2. JoinPoint获取切入点的相关信息, 使用的时候一定要放在方法参数列表的第一位
 */

@Aspect
public class Log {

    @Pointcut("execution(* com.lizza.spring_05_aop.aop_05_spring_aop_annotation.service.Calculator.*(..))")
    public void pointCut() {}

    /**
     * 前置通知：目标方法执行之前执行
     */
    @Before("pointCut()")
    public void beforeLog(JoinPoint point) {
        System.out.println(point.getSignature().getName() + "方法开始执行, 参数列表: " + Arrays.asList(point.getArgs()));
    }

    /**
     * 后置通知：目标方法执行之后执行
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterLog(JoinPoint point, Object result) {
        System.out.println(point.getSignature().getName() + "方法执行完成, 返回结果: " + result);
    }

    /**
     * 异常通知：目标方法执行发生异常时执行
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void exceptionLog(JoinPoint point, Exception e) {
        System.out.println(point.getSignature().getName() + "方法执行异常, 异常信息: " + e.getMessage());
    }

    /**
     * 最终通知：无论切入点执行发生异常与否，都会执行
     * 注意：基于注解的最终通知总会在后置通知或者异常通知之前执行
     */
    @After(value = "pointCut()")
    public void finalLog(JoinPoint point) {
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
