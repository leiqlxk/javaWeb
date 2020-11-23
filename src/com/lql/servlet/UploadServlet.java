package com.lql.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Title: UploadServlet <br>
 * ProjectName: javaWeb <br>
 * description: 上传文件 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 10:01 <br>
 */
public class UploadServlet extends HttpServlet {

    private String filePath;

    private String tempFilePath;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        //读取初始化参数
        filePath = servletConfig.getInitParameter("filePath");
        tempFilePath = servletConfig.getInitParameter("tempFilePath");

        //获取真实路径
        filePath = getServletContext().getRealPath(filePath);
        tempFilePath = getServletContext().getRealPath(tempFilePath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //定义缓冲区大小为4K
        factory.setSizeThreshold(4 * 1024);
        //设置临时目录
        factory.setRepository(new File(tempFilePath));

        //创建一个文件上传处理器
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //设置上传的文件最大尺寸为4M
        servletFileUpload.setFileSizeMax(4 * 1024 * 1024);

        try {
            List items = servletFileUpload.parseRequest(req);

            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();
                if (item.isFormField()) {
                    processFormField(item, writer);
                }else {
                    processUploadFile(item, writer);
                }
            }
            
            writer.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processUploadFile(FileItem item, PrintWriter writer) throws Exception {
        //获取包括路径的文件名
        String filename = item.getName();
        int index = filename.lastIndexOf("\\");
        //获取文件名
        filename = filename.substring(index + 1, filename.length());
        //获取文件大小
        Long fileSize = item.getSize();

        if ("".equals(filename) && fileSize == 0) {
            return;
        }

        File file = new File(filePath + "/" + filename);
        item.write(file);
        writer.println(filename + "is saved.");
        writer.println("The size of" + filename + " is " + fileSize + "\r\n");
    }

    private void processFormField(FileItem item, PrintWriter writer) {
        String name = item.getFieldName();
        String value = item.getString();

        writer.println(name + ":" + value + "\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
