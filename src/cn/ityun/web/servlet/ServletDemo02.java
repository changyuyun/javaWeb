package cn.ityun.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/demo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(req.getMethod());
        //虚拟目录
        resp.getWriter().println(req.getContextPath());//*
        //Servlet路径
        resp.getWriter().println(req.getServletPath());
        //获取请求URI
        resp.getWriter().println(req.getRequestURI());
        //请求参数
        resp.getWriter().println(req.getQueryString());
        //获取协议
        resp.getWriter().println(req.getProtocol());
        //远程ip
        resp.getWriter().println(req.getRemoteAddr());
        //
        resp.getWriter().println(req.getRemoteHost());
        resp.getWriter().println(req.getRemotePort());
        resp.getWriter().println(req.getLocalAddr());
        resp.getWriter().println(req.getLocalPort());
        //获取header
        resp.getWriter().println("============================================================");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = req.getHeader(name);
            resp.getWriter().println(name+"=====" +header );
        }
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
        resp.getWriter().println(req.getParameterMap());
        resp.getWriter().println(req.getParameterNames());
        resp.getWriter().println(req.getParameterValues("username"));
        //字符输入流
        BufferedReader reader = req.getReader();
        String length = null;
        while ((length = reader.readLine()) != null) {
            resp.getWriter().print(length);
        }

        System.out.println("post"+req.getMethod());
    }
}
