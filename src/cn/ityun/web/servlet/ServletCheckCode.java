package cn.ityun.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//验证码
@WebServlet(urlPatterns = "/CheckCode2")
public class ServletCheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //创建对象，在内存中图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //美化图片
        Graphics g = image.getGraphics();
        //背景
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        //边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0, width-1, height-1);
        //码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String code = "";
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char cr = str.charAt(index);
            g.drawString(cr+"", width/5*i, height/2);
            code += cr+"";
        }
        //设置session
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);
        session.setAttribute("sCode", code);
        //干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //输出图片
        ImageIO.write(image,"jpg", response.getOutputStream());
    }
}
