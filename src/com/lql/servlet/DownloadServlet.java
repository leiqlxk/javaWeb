package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Title: DownloadServlet <br>
 * ProjectName: javaWeb <br>
 * description: 下载文件 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/20 17:10 <br>
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream outputStream = null;
        InputStream inputStream = null;

        String filename = req.getParameter("filename");

        if (filename == null) {
            outputStream = resp.getOutputStream();
            outputStream.write("Please input filename.".getBytes());
            outputStream.close();
            return;
        }

        inputStream = getServletContext().getResourceAsStream("/store/" + filename);

        int length = inputStream.available();

        resp.setContentType("application/force-download");
        resp.setHeader("Content-Length", String.valueOf(length));
        resp.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

        outputStream=resp.getOutputStream();
        int bytesRead = 0;
        byte[] buffer = new byte[512];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
