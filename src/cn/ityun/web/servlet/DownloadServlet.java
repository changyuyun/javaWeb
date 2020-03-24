package cn.ityun.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String filename = request.getParameter("filename");
        downloadFileByOutputStream(response);

    }

    /**
     * 通过OutPutStream输出流下载文件
     * @param response
     * @throws IOException
     */
    private void downloadFileByOutputStream(HttpServletResponse response) throws IOException {
        String realPath = this.getServletContext().getRealPath("/images/c.jpg");
        String fileName = realPath.substring(realPath.lastIndexOf("\\") +1);
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        FileInputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(realPath);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }


    }
}
