package cn.ityun.web.servlet;

import cn.ityun.web.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置cookie
        /*Cookie cookie = new Cookie("name", "changyuyun");
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);*/

        //读取cookie
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie1 : cookies) {
            String name = cookie1.getName();
            String value = cookie1.getValue();
            int maxAge = cookie1.getMaxAge();
            response.getWriter().println(name+"==="+value+"==="+maxAge);
        }*/
        try {
            // 设置cookie
            CookieUtils.addCookie(response, "sex", "1", 3600);

            // 获取cookie
            Cookie cookie = CookieUtils.getCookieByName(request, "sex");
            String value = cookie.getValue();
            response.getWriter().println(value);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
