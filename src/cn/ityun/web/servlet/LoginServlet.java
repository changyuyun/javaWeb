package cn.ityun.web.servlet;

import cn.ityun.web.dao.UserDao;
import cn.ityun.web.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/loginS")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.手动获取方式
        /*String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User loginUser = new User();
        loginUser.setName(name);
        loginUser.setPwd(pwd);*/
        //2.beanutils获取方式
        //说明：JavaBean:标准的java类
        //类必须被public修饰
        //必须提供空参的构造器
        //成员变量必须使用private修饰
        //提供公共getter & setter
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        // resp.getWriter().println(name +"-----"+ pwd);
        resp.getWriter().println("user");
        if (user == null) {
            //resp.getWriter().println("failed");
            req.getRequestDispatcher("/failed").forward(req,resp);
        } else {
            //resp.getWriter().println("success");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/success").forward(req, resp);
        }

    }
}
