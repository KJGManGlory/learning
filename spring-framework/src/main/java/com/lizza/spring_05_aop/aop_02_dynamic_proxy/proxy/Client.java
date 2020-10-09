package com.lizza.spring_05_aop.aop_02_dynamic_proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-23
 */
public class Client {

    /**
     * JDK动态代理
     *  定义：可以在运行期动态创建某个interface的实例
     *  作用：在不修改源码的基础上实现对方法的增强
     *  特点：需要接口，并且实现类的实例
     *  分类：
     *      1. 基于接口的动态代理
     *      2. 基于子类的动态代理
     * 基于接口的动态代理
     *  涉及的类：Proxy
     *  提供者：JDK官方
     * 创建动态代理的要求
     *  被代理的类最少实现一个接口，如果没有则不能使用
     * newProxyInstance方法的参数
     *  ClassLoader：类加载器
     *      用于加载代理对象的字节码；与被代理对象使用相同的类加载器；固定写法
     *  Class<?>[]：字节码数组
     *
     *  InvocationHandler：用于提供增强的代码
     *      用于实现增强的代码；通常情况下是匿名内部类；非必需
     */
    public static void main(String[] args){
        Producer producer = new Producer();
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法时都会执行该方法
                     * @author: lizza@vizen.cn
                     * @date: 2020/3/23 9:19 下午
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需的参数
                     * @return          和被代理对象具有相同的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 1. 获取传入的参数
                        if("sale".equals(method.getName())) {
                            return method.invoke(producer, (float) args[0] * 0.8f);
                        }
                        return method.invoke(producer, args);
                    }
                }
        );
        proxyProducer.sale(10000);
    }
}
