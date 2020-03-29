package cn.ityun.web.servlet;

import cn.ityun.web.dao.UserDao;
import cn.ityun.web.domain.User;
import cn.ityun.web.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/LoginServlet")
public class Login2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        String name = null;
        String pwd = null;
        String code = null;
        for (Map.Entry<String, String[]> entry : entries) {
            String[] value = entry.getValue();
            if (value.length > 0) {
                if (entry.getKey().equals("name")) {
                    name = value[0];
                }
                if (entry.getKey().equals("pwd")) {
                    pwd = value[0];
                }
                if (entry.getKey().equals("code")) {
                    code = value[0];
                }
            }
        }
        System.out.println(name+"   "+ pwd+ "   "+code);
        if (name.length() == 0 || pwd.length() == 0 || code.length() == 0) {
            response.getWriter().println("name or pwd or code must is not empty!");
            return;
        }
        //验证码校验
        HttpSession session = request.getSession();
        Object sCode = session.getAttribute("sCode");
        if (!code.equalsIgnoreCase(sCode.toString())) {
            session.removeAttribute("sCode");
            response.getWriter().println("code is error!");
            return;
        }
        session.removeAttribute("sCode");
        User loginUser = new User();
        loginUser.setName(name);
        loginUser.setPwd(pwd);

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user == null) {
            response.getWriter().println("failed");
        } else {
            int id = user.getId();
            String username = user.getName();
            CookieUtils.addCookie(response,"username", username,3600);
            CookieUtils.addCookie(response,"id", id+"",3600);
            //request.getRequestDispatcher("/home.jsp").forward(request,response);
            response.sendRedirect("home.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
