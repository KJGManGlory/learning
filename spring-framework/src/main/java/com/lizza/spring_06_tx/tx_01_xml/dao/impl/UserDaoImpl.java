package com.lizza.spring_06_tx.tx_01_xml.dao.impl;


import com.lizza.spring_06_tx.tx_01_xml.dao.UserDao;
import com.lizza.spring_06_tx.tx_01_xml.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Override
    public int addOne(User user) {
        return super.getJdbcTemplate().update("insert into user (name, age, money) values (?, ?, ?)", user.getName(), user.getAge(), user.getMoney());
    }

    @Override
    public int deleteOne(int id) {
        return super.getJdbcTemplate().update("delete from user where id = ?", id);
    }

    @Override
    public int updateOne(User user) {
        return super.getJdbcTemplate().update("update user set name = ?, age = ?, money = ? where id = ?", user.getName(), user.getAge(), user.getMoney(), user.getId());
    }

    @Override
    public User findOne(int id) {
        Object[] args = new Object[1];
        args[0] = id;
        return super.getJdbcTemplate().query("select * from user where id = ?", args, new BeanPropertyRowMapper<>(User.class)).get(0);
    }

    @Override
    public List<User> findAll() {
        return super.getJdbcTemplate().query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
