package cn.ityun.web.service;

import cn.ityun.web.domain.User3;

import java.util.List;

public interface UserService {
    void addUser(User3 user);

    List<User3> findAll();

    int delUser(int id);

    int delUserSome(String ids);
}
