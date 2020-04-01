package cn.ityun.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter1_Web", urlPatterns = {"/FilterDemo01"})
public class Filter1_Web implements Filter {
    public void destroy() {
        System.out.println("Filter1_Web destroy 被调用");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter1_Web 客户端向服务端发送的请求拦截");
        chain.doFilter(req, resp);
        System.out.println("Filter1_Web 服务端向客户端发送的响应拦截");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter1_Web init 被调用");
    }

}
