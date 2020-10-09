package com.lizza.spring_02_ioc.ioc_01_base.factory;

import com.lizza.spring_02_ioc.ioc_01_base.dao.UserDao;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-07
 */
public class StaticBeanFactory {

    public static UserDao getUserDao() {
        return new UserDao();
    }
}
