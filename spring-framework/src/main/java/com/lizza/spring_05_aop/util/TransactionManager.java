package com.lizza.spring_05_aop.util;

import java.sql.SQLException;

/**
 *
 */
public class TransactionManager {

    private JdbcUtil jdbcUtil;

    public void setJdbcUtil(JdbcUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    /**
     * 开启事务
     * @author: lizza@vizen.cn
     * @date: 2020/3/22 9:48 下午
     * @param
     * @return void
     */
    public void start() {
        try {
            jdbcUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     * @author: lizza@vizen.cn
     * @date: 2020/3/22 9:48 下午
     * @param
     * @return void
     */
    public void commit() {
        try {
            jdbcUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     * @author: lizza@vizen.cn
     * @date: 2020/3/22 9:49 下午
     * @param
     * @return void
     */
    public void rollBack() {
        try {
            jdbcUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     * @author: lizza@vizen.cn
     * @date: 2020/3/22 9:49 下午
     * @param
     * @return void
     */
    public void release() {
        try {
            jdbcUtil.getConnection().close();
            jdbcUtil.release();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
