package com.lizza.spring_06_tx.tx_01_xml.service.impl;

import com.lizza.spring_06_tx.tx_01_xml.dao.UserDao;
import com.lizza.spring_06_tx.tx_01_xml.entity.User;
import com.lizza.spring_06_tx.tx_01_xml.service.UserService;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-31
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int addOne(User user) {
        return userDao.addOne(user);
    }

    @Override
    public int deleteOne(int id) {
        return userDao.deleteOne(id);
    }

    @Override
    public int updateOne(User user) {
        return userDao.updateOne(user);
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int transferMoney(int from_id, int to_id, double money) {
        // 1. 获取付款账户和收款账户
        User from_user = userDao.findOne(from_id);
        User to_user = userDao.findOne(to_id);
        // 2. 付款账户付款，收款账户收款
        from_user.setMoney(from_user.getMoney() - money);
        to_user.setMoney(to_user.getMoney() + money);
        // 3. 更新账户信息
        userDao.updateOne(from_user);
//        int i = 100/0;
        userDao.updateOne(to_user);
        return 0;
    }
}
