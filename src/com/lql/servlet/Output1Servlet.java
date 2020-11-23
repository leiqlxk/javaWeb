package com.lql.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title: OutputServlet <br>
 * ProjectName: javaWeb <br>
 * description: 重定向测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2020/11/23 13:46 <br>
 */
public class Output1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取request中的msg属性
        String message = (String) req.getAttribute("msg");
        System.out.println("请求范围内的消息：" + message);

        message = req.getParameter("msg");
        System.out.println("请求参数中的消息：" + message);

        PrintWriter out = resp.getWriter();
        out.println(message);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
