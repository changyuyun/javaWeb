package cn.ityun.web.test;

import cn.ityun.web.dao.UserDao;
import cn.ityun.web.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setName("chang");
        user.setPwd("123123");
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }
}
