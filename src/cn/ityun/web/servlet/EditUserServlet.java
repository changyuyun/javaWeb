package cn.ityun.web.servlet;

import cn.ityun.web.domain.User3;
import cn.ityun.web.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User3 user = new User3();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int id = user.getId();
        UserServiceImpl userService = new UserServiceImpl();
        int ret = userService.updateUser(user, id);
        response.sendRedirect(request.getContextPath() + "/UserListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer realId = Integer.parseInt(id);
        if (realId == 0) {
            response.getWriter().println("action error!");
        } else {
            UserServiceImpl userService = new UserServiceImpl();
            List<User3> user = userService.findOne(realId);
            request.setAttribute("user", user.get(0));
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }
    }
}
