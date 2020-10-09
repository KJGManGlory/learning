package com.lizza.spring_05_aop.service.impl;

import com.lizza.spring_05_aop.entity.User;
import com.lizza.spring_05_aop.dao.UserDao;
import com.lizza.spring_05_aop.service.UserService;

import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-03-11
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 使用set注入dao
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

    /**
     * 转账操作
     * @author: lizza@vizen.cn
     * @date: 2020/3/20 11:36 下午
     * @param originAccount
     * @param targetAccount
     * @param money
     * @return int
     */
    @Override
    public int transferMoney(Integer originAccount, Integer targetAccount, Double money) {
        User originUser = userDao.findOne(originAccount);
        User targetUser = userDao.findOne(targetAccount);
        double originMoney = originUser.getMoney() - money;
        originUser.setMoney(originMoney);
        double targetMoney = targetUser.getMoney() + money;
        targetUser.setMoney(targetMoney);
        userDao.updateOne(originUser);
//        int num = 1/0;
        return userDao.updateOne(targetUser);
    }
}
