package com.lql.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Title: ImageServlet <br>
 * ProjectName: javaWeb <br>
 * description: 动态生成图像 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 10:46 <br>
 */
public class ImageServlet extends HttpServlet {

    private Font font = new Font("Courier", Font.BOLD, 12);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String count = req.getParameter("count");
        if (count == null) {
            count = "1";
        }

        int lenth = count.length();

        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        //创建一个位于缓存中的图像
        BufferedImage image = new BufferedImage(11*lenth, 16, BufferedImage.TYPE_INT_RGB);

        //获得Graphics画笔
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 11*lenth, 16);

        graphics.setColor(Color.white);
        graphics.setFont(font);

        char c;
        for (int i = 0; i < lenth; i++) {
            c = count.charAt(i);
            //写一个白色数字
            graphics.drawString(c + "", i*11+1, 12);
            //画一条白色竖线
            graphics.drawLine((i+1)*11-1, 0, (i+1)*11-1, 16);
        }

        //输出JPEG格式图片
        JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
        jpegImageEncoder.encode(image);
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
