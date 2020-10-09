package com.lizza.spring_02_ioc.ioc_02_xml.dao.impl;

import com.lizza.spring_02_ioc.ioc_02_xml.dao.UserDao;
import com.lizza.spring_02_ioc.ioc_02_xml.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-16
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public int addOne(User user) {
        try {
            return queryRunner.update("insert into user (id, name, age) values (?, ?, ?)", user.getId(), user.getName(), user.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOne(int id) {
        try {
            return queryRunner.update("delete from user where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateOne(User user) {
        try {
            return queryRunner.update("update user set name = ?, age = ? where id = ?", user.getName(), user.getAge(), user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User findOne(int id) {
        try {
            return queryRunner.query("select * from user where id = ?", new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            return queryRunner.query("select * from user", new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
