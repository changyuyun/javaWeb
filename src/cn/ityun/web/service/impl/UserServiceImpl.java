package cn.ityun.web.service.impl;

import cn.ityun.web.dao.UserDao;
import cn.ityun.web.domain.User3;
import cn.ityun.web.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User3 user) {
        UserDao userDao = new UserDao();
        userDao.add(user);
    }

    @Override
    public List<User3> findAll() {
        UserDao userDao = new UserDao();
        List<User3> list = userDao.findAll();
        return list;
    }
}
