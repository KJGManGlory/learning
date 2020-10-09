package com.lizza.spring_05_aop.aop_02_dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-23
 */
public class Client {

    /**
     * cglib动态代理
     *  定义：可以在运行期动态创建某个class的实例
     *  作用：在不修改源码的基础上实现对方法的增强
     *  特点：对指定类进行代理
     *  分类：
     *      1. 基于接口的动态代理
     *      2. 基于子类的动态代理
     * 基于接口的动态代理
     *  涉及的类：Proxy
     *  提供者：第三方cglib库
     * 创建动态代理的要求
     *  被代理的类不能用final修饰
     * 如何创建代理对象
     *  使用Enhancer类中的create方法
     * create方法的参数
     *  ClassLoader：类加载器
     *      用于加载代理对象的字节码；与被代理对象使用相同的类加载器；固定写法
     *  Class<?>[]：字节码数组
     *
     *  Callback：用于提供增强的代码
     *      用于实现增强的代码；通常情况下是匿名内部类；非必需
     *      一般创建MethodInterceptor
     */
    public static void main(String[] args){
        Producer producer = new Producer();
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), producer.getClass().getInterfaces(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @author: lizza@vizen.cn
             * @date: 2020/3/25 8:21 下午
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy
             * @return java.lang.Object
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 1. 获取传入的参数
                if("sale".equals(method.getName())) {
                    return method.invoke(producer, (float) args[0] * 0.8f);
                }
                return method.invoke(producer, args);
            }
        });
        cglibProducer.sale(12000);
    }
}
