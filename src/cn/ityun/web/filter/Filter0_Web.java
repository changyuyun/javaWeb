package cn.ityun.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//多个Filter过滤器，通过过滤器名称来控制调用顺序
@javax.servlet.annotation.WebFilter(filterName = "Filter0_Web", urlPatterns = {"/FilterDemo01"})
public class Filter0_Web implements Filter {
    private FilterConfig filterConfig;
    public void destroy() {
        System.out.println("Filter0_Web destroy 被调用");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter0_Web 客户端向服务端发送的请求拦截");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        ServletContext application = filterConfig.getServletContext();
        Map<String, Integer> ipCount = (HashMap<String, Integer>) application.getAttribute("ipCount");
        String ip = req.getRemoteAddr();
        Integer count = ipCount.get(ip);
        if (count != null) {
            count = count + 1;
        } else {
            count = 1;
        }
        ipCount.put(ip, count);
        application.setAttribute("ipCount", ipCount);
        chain.doFilter(req, resp);
        System.out.println(ipCount);
        System.out.println("Filter0_Web 服务端向客户端发送的响应拦截");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter0_Web init 被调用");
        filterConfig = config;
        //实现一个访问ip统计
        ServletContext application = filterConfig.getServletContext();
        HashMap<String, Integer> ipCount = new HashMap<>();
        application.setAttribute("ipCount", ipCount);
    }

}
