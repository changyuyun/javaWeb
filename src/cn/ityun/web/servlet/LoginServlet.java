package cn.ityun.web.servlet;

import cn.ityun.web.dao.UserDao;
import cn.ityun.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/loginS")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        User loginUser = new User();
        loginUser.setName(name);
        loginUser.setPwd(pwd);
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        resp.getWriter().println(name +"-----"+ pwd);
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
