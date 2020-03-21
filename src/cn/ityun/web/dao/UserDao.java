package cn.ityun.web.dao;

import cn.ityun.web.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.ityun.web.util.JDBCUtils2;

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
}