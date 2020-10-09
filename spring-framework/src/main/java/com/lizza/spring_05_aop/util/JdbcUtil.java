package com.lizza.spring_05_aop.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-21
 */
public class JdbcUtil {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private ComboPooledDataSource dataSource;

    public void setDataSource(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        // 1. 获取当前线程绑定的连接
        Connection connection = threadLocal.get();
        try {
            // 2. 若没有，则从连接池中获取一个返回，并且存入ThreadLocal
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * 如果使用线程池提供线程，将线程池中的连接与线程解绑
     * @author: lizza@vizen.cn
     * @date: 2020/3/22 9:52 下午
     * @param
     * @return void
     */
    public void release() {
        threadLocal.remove();
    }

}
