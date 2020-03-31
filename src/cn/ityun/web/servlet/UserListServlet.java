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

@WebServlet(urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*UserServiceImpl userService = new UserServiceImpl();
        List<User3> users = userService.findAll();
        request.setAttribute("users", users);*/
        //TODO:实现分页
        Integer page = ParameterUtils.getInt(request, "page", 1);
        Integer pageSize = ParameterUtils.getInt(request, "pageSize", 10);
        PageListUtils pageList = new PageListUtils();
        UserServiceImpl userService = new UserServiceImpl();
        List<User3> list = userService.findAllByPage(page, pageSize);

        int count = userService.countAll();

        int pages = 0;
        if (count % pageSize == 0) {
            pages = count/pageSize;
        } else {
            pages = count/pageSize + 1;
        }
        pageList.setPage(page);
        pageList.setTotalRows(count);
        pageList.setPages(pages);
        pageList.setPageSize(pageSize);
        pageList.setList(list);
        System.out.println(pageList);
        request.setAttribute("list", pageList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
