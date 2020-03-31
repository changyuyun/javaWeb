package cn.ityun.web.dao;

import cn.ityun.web.domain.User;
import cn.ityun.web.domain.User3;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.ityun.web.util.JDBCUtils2;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import java.util.List;

/**
 * 操作表
 */
public class UserDao {
    //声明jdbcTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
    /**
     * 获取用户名 密码
     * @param loginUser
     * @return 用户数据
     */
    public User login(User loginUser) {
        try {
            String name = loginUser.getName();
            String pwd = loginUser.getPwd();
            String sql = "select * from user where name=? and pwd=?";
            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    name,
                    pwd
            );
            return user;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public void add(User3 user) {
        String sql = "insert into user values (null,null,null,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getEmail(), user.getBirthday(), user.getSex());
    }

    public List<User3> findAll() {
        String sql = "select id, username,email,birthday,sex from user order by id desc";
        List<User3> list = template.query(sql, new BeanPropertyRowMapper<User3>(User3.class));
        return list;
    }

    public List<User3> findOne(int id) {
        String sql = "select id, username,email,birthday,sex from user where id=? limit 1";
        List<User3> list = template.query(sql, new BeanPropertyRowMapper<User3>(User3.class), id);
        return list;
    }

    public int del(int id) {
        String sql = "delete from user where id=?";
        return template.update(sql, id);
    }

    public int delSome(String ids) {
        String sql = "delete from user where id in ("+ids+")";
        return template.update(sql);
    }

    public int update(User3 user, int id) {
        String sql = "update user set username=?,email=?,birthday=?,sex=? where id=?";
        return template.update(sql, user.getUsername(), user.getEmail(), user.getBirthday(), user.getSex(), id);
    }

    public int count() {
        String sql = "select* from user";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        template.query(sql, countCallback);
        int count = countCallback.getRowCount();
        return count;
    }

    public List<User3> findAllByPage(int page, int pageSize) {
        int starter = (page-1)*pageSize;
        String sql = "select id, username,email,birthday,sex from user limit " + starter + " , "+pageSize;
        List<User3> list = template.query(sql, new BeanPropertyRowMapper<User3>(User3.class));
        return list;
    }
}
