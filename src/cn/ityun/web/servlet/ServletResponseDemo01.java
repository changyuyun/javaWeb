package cn.ityun.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ResponseDemo01")
public class ServletResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo01");
        //重定向
        /*response.setStatus(302);
        response.setHeader("location", "/ResponseDemo02");*/
        // response.sendRedirect("/ResponseDemo02");
        //设置编码
        // response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        //输出字符数据
        // response.getWriter().println("常育云");
        //输出字节数据  一般用于输出图片数据
        response.getOutputStream().write("hello:常育云".getBytes("utf-8"));
    }
}
