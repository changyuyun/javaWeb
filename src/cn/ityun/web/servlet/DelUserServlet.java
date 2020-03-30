package cn.ityun.web.servlet;

import cn.ityun.web.domain.JsonMessage;
import cn.ityun.web.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("application/json;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int realId = Integer.parseInt(id);
        UserServiceImpl userService = new UserServiceImpl();
        int ret = userService.delUser(realId);
        Gson gson = new Gson();
        String message = "";
        if (ret > 0) {
            JsonMessage success = new JsonMessage(0, "success");
            message = gson.toJson(success);
        } else {
            JsonMessage failed = new JsonMessage(-1, "failed");
            message = gson.toJson(failed);
        }
        response.getWriter().println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
