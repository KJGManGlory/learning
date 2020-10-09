package com.lizza.spring_05_aop.aop_01_aop.factory;

import com.lizza.spring_05_aop.aop_01_aop.util.TransactionManager;
import com.lizza.spring_05_aop.aop_01_aop.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-25
 */
public class BeanFactory {

    private UserService userService;

    private TransactionManager txManager;

    public UserService getUserService() {
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            // 1. 开启事务
                            txManager.start();
                            // 2. 执行操作
                            result = method.invoke(userService, args);
                            // 3. 提交事务
                            txManager.commit();
                        } catch (Exception e) {
                            // 4. 异常回滚
                            txManager.rollBack();
                            e.printStackTrace();
                        } finally {
                            // 5. 释放资源
                            txManager.release();
                        }

                        return result;
                    }
                });
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
}
