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
import java.util.Arrays;

@WebServlet(urlPatterns = "/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actType = request.getParameter("actType");
        if (actType.equals("one")) {
            delOne(request, response);
        } else {
            delSome(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @desc 删除一个
     * @param request
     * @param response
     */
    private void delOne(HttpServletRequest request, HttpServletResponse response) {
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
        try {
            response.getWriter().println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc 删除多个
     * @param request
     * @param response
     */
    private void delSome(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        String[] idsArr = ids.split(",");
        Gson gson = new Gson();
        String message = "";
        if (idsArr.length == 0) {
            JsonMessage failed = new JsonMessage(-1, "failed");
            message = gson.toJson(failed);
        } else {
            UserServiceImpl userService = new UserServiceImpl();
            int ret = userService.delUserSome(ids);
            System.out.println(ret);
            if (ret > 0) {
                JsonMessage success = new JsonMessage(0, "success");
                message = gson.toJson(success);
            } else {
                JsonMessage failed = new JsonMessage(-1, "failed");
                message = gson.toJson(failed);
            }
        }
        System.out.println(Arrays.toString(idsArr));
        try {
            response.getWriter().println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
