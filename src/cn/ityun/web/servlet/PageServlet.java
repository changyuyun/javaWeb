package cn.ityun.web.servlet;

import cn.ityun.web.domain.User3;
import cn.ityun.web.service.impl.UserServiceImpl;
import cn.ityun.web.util.PageListUtils;
import cn.ityun.web.util.ParameterUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//测试分页
@WebServlet(urlPatterns = "/PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        Integer realPage = 1;
        Integer realPageSize = 10;
        if (page != null && ParameterUtils.isNumber(page)) {
            realPage = Integer.parseInt(page);
        }
        if (pageSize != null && ParameterUtils.isNumber(pageSize)) {
            realPageSize = Integer.parseInt(pageSize);
        }
        PageListUtils pageList = new PageListUtils();
        UserServiceImpl userService = new UserServiceImpl();
        List<User3> list = userService.findAllByPage(realPage, realPageSize);

        int count = userService.countAll();

        int pages = 0;
        if (count % realPageSize == 0) {
            pages = count/realPageSize;
        } else {
            pages = count/realPageSize + 1;
        }
        pageList.setPage(realPage);
        pageList.setTotalRows(count);
        pageList.setPages(pages);
        pageList.setList(list);
        System.out.println(pageList);
    }
}
